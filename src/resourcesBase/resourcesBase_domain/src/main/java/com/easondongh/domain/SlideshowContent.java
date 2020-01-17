package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author EasonDongH
 */
@Data
public class SlideshowContent implements Serializable {

    public static final int USE = 1;

    private Long id;

    private Long aid;

    private Long photoId;

    private String summarize;

    private int status;
}
