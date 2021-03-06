// --== CS400 File Header Information ==--
// Name: William Langas
// Email: wlangas@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Ta
// Lecturer: Gary Dahl

import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.util.zip.DataFormatException;

// --== CS400 File Header Information ==--
// Author: CS400 Course Staff
// Email: heimerl@cs.wisc.edu / dahl@cs.wisc.edu
// Notes: This interface is part of the starter archive for Projecct One
//        in spring 2021.
public interface MovieDataReaderInterface {
	
	public List<MovieInterface> readDataSet(Reader inputFileReader) throws DataFormatException, IOException;

}
