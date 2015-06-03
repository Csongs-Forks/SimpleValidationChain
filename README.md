I thought this library came quite handy on a project I did work on so I thought to share it with anyone with similar need.

The library is designed to be configured with minimal semantics which can be used in single function or so. User can create chains of validation and
hook up different validation engines to it, e.g. Commons Validation.

The better option would be annotations, but we could not use them so I created this library.

Development was done so that the 'ideal' form was written to a unit test and then I used Chain Of Responsiblity pattern to solve this problem.

The validation has a small memory so that certain behavior can be inherited and overridden as that seemed to be the case when validating fields.

There's so much more I could do with the library, but I rather spend the time elsewhere.

MIT Licence.. use as you wish, no credit needed but neither am I responsible if it breaks.
