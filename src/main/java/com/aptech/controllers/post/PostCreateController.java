package com.aptech.controllers.post;

import com.aptech.dao.CategoryDao;
import com.aptech.dao.PostDao;
import com.aptech.models.Category;
import com.aptech.models.Post;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/post-create")
public class PostCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = CategoryDao.all();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("posts/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category = 0;
        String title = null;
        String content = null;
        String image = null;

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        if (isMultipart) {
            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);

                // Process the uploaded items
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (item.isFormField()) {
                        if (item.getFieldName().equals("title")) {
                            title = item.getString();
                        }
                        if (item.getFieldName().equals("content")) {
                            content = item.getString();
                        }
                        if (item.getFieldName().equals("category")) {
                            if (!item.getString().isEmpty()) {
                                category = Integer.parseInt(item.getString());
                            }

                        }

                    } else {
                        if (!item.getName().isEmpty()) {
                            image = processUploadedFile(item);
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no file upload made");
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImagePath(image);
        post.setCategoryId(category);
        PostDao.store(post);
        response.sendRedirect("posts");
    }

    private String processUploadedFile(FileItem item) {
        String fileName = item.getName();
        String root = this.getServletContext().getRealPath("/");
        File path = new File(root + "/uploads");
        if (!path.exists()) {
            boolean status = path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            item.write(uploadedFile);
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
