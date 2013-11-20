import com.example.creators.AbstractRomanNumberFactory;
import com.example.creators.NumberCreator;
import com.example.creators.RomanNumberFactory;
import com.example.creators.SuccessiveRomanNumberFactory;
import com.example.model.RomanNumber;
import com.example.roman.evaluators.ArabicNumberEvaluator;
import com.example.roman.evaluators.ArabicNumberEvaluatorImpl;
import com.example.roman.evaluators.RomanNumberEvaluator;
import com.example.roman.evaluators.RomanNumberEvaluatorImpl;
import com.example.validators.Validator;
import com.example.validators.ValidatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * User: pankaj
 * Date: 11/17/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class RomanNumberEvaluatorTest {
    RomanNumber I, V, X, L, C, D, M;
    RomanNumberEvaluator evaluator;
    Validator validator;
    ArabicNumberEvaluator arabicNumberEvaluator;

    @Before
    public void beforeTest() {
        AbstractRomanNumberFactory fact = AbstractRomanNumberFactory.getInstance();
        NumberCreator romanNumberCreator = new RomanNumberFactory();
        NumberCreator successiveRomanCreator = new SuccessiveRomanNumberFactory();
        I = fact.getNumberFor(1, 4, successiveRomanCreator);
        V = fact.getNumberFor(5, -1, romanNumberCreator);
        X = fact.getNumberFor(10, 4, successiveRomanCreator);
        L = fact.getNumberFor(50, -1, romanNumberCreator);
        C = fact.getNumberFor(100, 4, successiveRomanCreator);
        D = fact.getNumberFor(500, -1, romanNumberCreator);
        M = fact.getNumberFor(1000, 4, successiveRomanCreator);

        I.addCanBeSubstractList(V, X);
        X.addCanBeSubstractList(L, C);
        C.addCanBeSubstractList(D, M);
        evaluator = new RomanNumberEvaluatorImpl();
        validator = new ValidatorImpl();
        arabicNumberEvaluator = new ArabicNumberEvaluatorImpl();

    }

    @Test
    public void testTranslationToDigits() {
        assertEquals(16, evaluator.evaluate(X, V, I));
    }

    @Test
    public void testTransationToDigitWithLower() {
        assertEquals(1944, evaluator.evaluate(M, C, M, X, L, I, V));
    }

    @Test
    public void testTranslationToDigitAnother() {
        assertEquals(1903, evaluator.evaluate(M, C, M, I, I, I));
    }

    @Test
    public void testSuccessiveRepeatCase() {
        Map<Object, Object> errMap = validator.validate(I, I, I, I);
        Map<RomanNumber, String> expectedMap = new HashMap<RomanNumber, String>();
        expectedMap.put(I, "Repeat Number found");
        assertEquals(expectedMap, errMap);
    }

    @Test
    public void testSuccessiveRepoeatValidationAnotherCase() {
        Map<Object, Object> errMap = validator.validate(I, I, X, X, X, X);
        Map<RomanNumber, String> expectedMap = new HashMap<RomanNumber, String>();
        expectedMap.put(X, "Repeat Number found");
        assertEquals(expectedMap, errMap);
    }

    @Test
    public void testAllowedRepeatCase() {
        Map<Object, Object> errMap = validator.validate(X, X, X, I, X);
        assertEquals(0, errMap.size());
    }

    @Test
    public void testNonSuccessiveRepeatCase() {
        Map<Object, Object> errMap = validator.validate(D, D, D, D);
        assertEquals(0, errMap.size());
    }

    @Test
    public void testArabicNumber() {
        List<RomanNumber> expectedResult = new ArrayList<RomanNumber>();
        expectedResult.addAll(Arrays.asList(I, V));
        assertEquals(expectedResult, arabicNumberEvaluator.evaluate(4));
    }

    @Test
    public void testArabicNumberCase1() {
        List<RomanNumber> expectedResult = new ArrayList<RomanNumber>();
        expectedResult.addAll(Arrays.asList(V, I));
        assertEquals(expectedResult, arabicNumberEvaluator.evaluate(6));
    }

    @Test
    public void testArabicNumberCase2() {
        List<RomanNumber> expectedResult = new ArrayList<RomanNumber>();
        expectedResult.addAll(Arrays.asList(V, I, I));
        assertEquals(expectedResult, arabicNumberEvaluator.evaluate(7));
    }

    @Test
    public void testArabicNumberCase3() {
        List<RomanNumber> expectedResult = new ArrayList<RomanNumber>();
        expectedResult.addAll(Arrays.asList(I, I, I));
        assertEquals(expectedResult, arabicNumberEvaluator.evaluate(3));
    }

    @Test
    public void testArabicNumberCase4() {
        List<RomanNumber> expectedResult = new ArrayList<RomanNumber>();
        expectedResult.addAll(Arrays.asList(M, C, M, I, I, I));
        assertEquals(expectedResult, arabicNumberEvaluator.evaluate(1903));
    }
}
