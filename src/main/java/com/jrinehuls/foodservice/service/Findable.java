package com.jrinehuls.foodservice.service;

import com.jrinehuls.foodservice.exception.conflict.ConflictException;
import com.jrinehuls.foodservice.exception.notfound.NotFoundException;

import java.util.function.Supplier;

public interface Findable<T, ID> {
    <X extends NotFoundException> T findByIdOrThrow(ID id, Supplier<X> supplier);

}
