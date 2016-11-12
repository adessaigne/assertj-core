/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.api;

import static org.assertj.core.error.ShouldBeMarked.shouldBeMarked;
import static org.assertj.core.error.ShouldBeMarked.shouldNotBeMarked;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Assertion methods for {@link AtomicMarkableReference}s.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(AtomicMarkableReference)}</code>.
 * </p>
 *
 * @author epeee
 */
public class AtomicMarkableReferenceAssert<VALUE>
    extends AbstractAtomicAssert<AtomicMarkableReferenceAssert<VALUE>, VALUE, AtomicMarkableReference<VALUE>> {

  public AtomicMarkableReferenceAssert(AtomicMarkableReference<VALUE> actual) {
    super(actual, AtomicMarkableReferenceAssert.class, true);
  }

  @Override
  protected VALUE getActualValue() {
    return actual.getReference();
  }

  /**
   * Verifies that the actual {@link AtomicMarkableReference} is marked.
   * <p>
   * Examples:
   * <pre><code class='java'> // this assertion succeeds:
   * assertThat(new AtomicMarkableReference&lt;&gt;("actual", true)).isMarked();
   *
   * // this assertion fails:
   * assertThat(new AtomicMarkableReference&lt;&gt;("actual", false)).isMarked();</code></pre>
   *
   * @param expected the expected marked inside the {@link AtomicMarkableReference}.
   * @return this assertion object.
   */
  public AtomicMarkableReferenceAssert<VALUE> isMarked() {
    boolean marked = actual.isMarked();
    if (!marked) throwAssertionError(shouldBeMarked(actual));
    return this;
  }

  /**
   * Verifies that the actual {@link AtomicMarkableReference} is <b>not</b> marked.
   * <p>
   * Examples:
   * <pre><code class='java'> // this assertion succeeds:
   * assertThat(new AtomicMarkableReference&lt;&gt;("actual", false)).isNotMarked();
   *
   * // this assertion fails:
   * assertThat(new AtomicMarkableReference&lt;&gt;("actual", true)).isNotMarked();</code></pre>
   *
   * @param expected the expected marked inside the {@link AtomicMarkableReference}.
   * @return this assertion object.
   */
  public AtomicMarkableReferenceAssert<VALUE> isNotMarked() {
    boolean marked = actual.isMarked();
    if (marked) throwAssertionError(shouldNotBeMarked(actual));
    return this;
  }
}