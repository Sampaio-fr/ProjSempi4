package eapli.base.postIt.domain;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;

/**
 * The type Post it.
 */

@Entity
@Table
public class PostIt implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long postItId;

    @Embedded
    private Title title ;

    @Embedded
    private Description description;

    /**
     * Instantiates a new Post-it.
     *
     * @param title       the title
     * @param description the description
     */
    public PostIt(Title title, Description description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Instantiates a new Post it.
     */
    public PostIt() {

    }

    /**
     * Post it long.
     *
     * @return the long
     */
    public Long postIt() {
        return postItId;
    }

    /**
     * Replace post it.
     *
     * @param postIt the post it
     */
    public void replacePostIt(Long postIt) {
        this.postItId = postIt;
    }

    /**
     * Title title.
     *
     * @return the title
     */
    public Title title() {
        return title;
    }

    /**
     * Replace title.
     *
     * @param title the title
     */
    public void replaceTitle(Title title) {
        this.title = title;
    }

    /**
     * Description description.
     *
     * @return the description
     */
    public Description description() {
        return description;
    }

    /**
     * Replace description.
     *
     * @param description the description
     */
    public void replaceDescription(Description description) {
        this.description = description;
    }

    @Override
    public Long identity() {
        return this.postItId;
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof PostIt)) {
            return false;
        }

        final PostIt that = (PostIt) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) &&
                this.title.equals(that.title) &&
                this.description.equals(that.description);
    }




    @Override
    public String toString() {
        return "PostIt" + "\n" +
                "Id ->" + postItId
                + title + "\n"
                + description + "\n";
    }

    public String htmlString() {
        return "<b>" + title + "</b><br><br>" + description;
    }
}
