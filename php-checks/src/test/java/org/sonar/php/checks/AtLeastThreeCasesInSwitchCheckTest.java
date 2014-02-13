/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010 Codehaus Sonar Plugins
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.php.checks;

import org.junit.Test;
import org.sonar.php.PHPAstScanner;
import org.sonar.plugins.php.CheckTest;
import org.sonar.plugins.php.TestUtils;
import org.sonar.squid.api.SourceFile;

public class AtLeastThreeCasesInSwitchCheckTest extends CheckTest {

  @Test
  public void test() {
    SourceFile file = PHPAstScanner.scanSingleFile(TestUtils.getCheckFile("AtLeastThreeCasesInSwitchCheck.php"), new AtLeastThreeCasesInSwitchCheck());

    checkMessagesVerifier.verify(file.getCheckMessages())
      .next().atLine(3).withMessage("Replace this \"switch\" statement with \"if\" statements to increase readability.")
      .next().atLine(12)
      .next().atLine(15)
      .noMore();
  }
}
