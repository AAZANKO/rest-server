package by.declarant.server.converter;

public interface Converter<T, R>  {

    R converter(T object);
}
