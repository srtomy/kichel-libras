package io.github.srtomy.model;

import java.util.Objects;

public class Keyword {
    private String description;
    private Theme theme;

    //get e set
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword keyword = (Keyword) o;
        return Objects.equals(description, keyword.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
