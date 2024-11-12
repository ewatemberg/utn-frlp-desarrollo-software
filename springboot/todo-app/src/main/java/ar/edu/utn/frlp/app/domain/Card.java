package ar.edu.utn.frlp.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "order_column")
    private Integer order;
    @ManyToOne
    private ColumnBoard columnBoard;

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ColumnBoard getColumnBoard() {
        return columnBoard;
    }

    public void setColumnBoard(ColumnBoard columnBoard) {
        this.columnBoard = columnBoard;
    }
}
