package morphy.examples;

import java.util.regex.Pattern;

import morphy.annotations.Datamorphism;
import morphy.annotations.TestCase;

// Example of datamorphic test specification for testing a classifier.

public class TwoImageDatamorphsims {
	
	@Datamorphism
	public TestCase<TwoImage, Double> Bald(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Bald" +"\\" + i2s[1]);
		mutant.input = newInput;
		return mutant;
	}

	@Datamorphism
	public TestCase<TwoImage, Double> Bangs(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Bangs" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}

	@Datamorphism
	public TestCase<TwoImage, Double> Black_Hair(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Black_Hair" + "\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}

	@Datamorphism
	public TestCase<TwoImage, Double> Bushy_Eyebrows(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Bushy_Eyebrows" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Blond_Hair(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Blond_Hair" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Brown_Hair(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Brown_Hair" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Eyeglasses(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Eyeglasses" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Male(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Male" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Mouth_Slightly_Open(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Mouth_Slightly_Open" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Mustache(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Mustache" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> No_Beard(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "No_Beard" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Pale_Skin(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Pale_Skin" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
	
	@Datamorphism
	public TestCase<TwoImage, Double> Young(TestCase<TwoImage, Double> seed){
		TestCase<TwoImage, Double> mutant = new TestCase<TwoImage, Double>();
		String[] i2s = seed.input.i2.split(Pattern.quote("\\"));
		TwoImage newInput = new TwoImage(seed.input.path, seed.input.i1, "Young" +"\\"+ i2s[1]);
		mutant.input = newInput;
		return mutant;
	}
}