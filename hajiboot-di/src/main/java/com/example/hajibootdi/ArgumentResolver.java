package com.example.hajibootdi;

import java.io.InputStream;

public interface ArgumentResolver {
  Argument resolve(InputStream stream);
}
