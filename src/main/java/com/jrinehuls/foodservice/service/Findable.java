package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.exception.conflict.ConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;
import io.swagger.v3.oas.models.media.XML;

import java.util.Optional;
import java.util.function.Supplier;

public interface Findable<T, ID> {
    <X extends NotFoundException> T findByIdOrThrow(ID id, Supplier<X> supplier);
    <X extends ConflictException> void throwIfExists(String field, Supplier<X> supplier);
}
