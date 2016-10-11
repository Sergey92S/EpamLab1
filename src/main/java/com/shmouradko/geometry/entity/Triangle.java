package com.shmouradko.geometry.entity;

/**
 * Created by Сергей on 04.10.2016.
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private long triangleId;

    public Triangle(long triangleId, Point a, Point b, Point c) {
        this.triangleId = triangleId;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public long getTriangleId() {
        return triangleId;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", triangleId=" + triangleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (triangleId != triangle.triangleId) return false;
        if (a != null ? !a.equals(triangle.a) : triangle.a != null) return false;
        if (b != null ? !b.equals(triangle.b) : triangle.b != null) return false;
        return c != null ? c.equals(triangle.c) : triangle.c == null;

    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (int) (triangleId ^ (triangleId >>> 32));
        return result;
    }
}
