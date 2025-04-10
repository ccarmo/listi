package com.dev.listi.os.core.vo;

public class Link {

    private static final String PATH_PATTERN = "^(/[a-zA-Z0-9\\-]+)+$";

    private String path;

    public Link() {
    }

    public Link(String path) {
        validatePath(path);
    }


    public void validatePath(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("O path não pode ser nulo ou vazio.");
        }
        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("O path deve começar com '/'.");
        }
        if (!path.matches(PATH_PATTERN)) {
            throw new IllegalArgumentException("O path deve seguir o padrão: começar com '/' e conter apenas letras, números, hífens e barras.");
        }
        this.path = path;
    }

    public String getPathString() {
        return this.path;
    }

    @Override
    public String toString() {
        return "Link{" +
                "path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return path.equals(link.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}
