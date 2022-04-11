package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@DiscriminatorValue(value = "Book")
public class Book extends Item{
    @Id @GeneratedValue
    private Long id;

    private String author;
    private String isbn;

}
