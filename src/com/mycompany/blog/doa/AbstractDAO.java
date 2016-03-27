package com.mycompany.blog.doa;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();
}
