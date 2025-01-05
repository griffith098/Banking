document.addEventListener("DOMContentLoaded", function () {
  const forms = document.querySelectorAll("form");
  forms.forEach(form => {
    form.addEventListener("submit", function (e) {
      const emailField = form.querySelector("input[name='email']");
      const passwordField = form.querySelector("input[name='password']");
      const amountField = form.querySelector("input[name='amount']");

      // Validate email
      if (emailField && !validateEmail(emailField.value)) {
        e.preventDefault();
        alert("Please enter a valid email address!");
        emailField.focus();
        return false;
      }

      // Validate password (if password field exists)
      if (passwordField && passwordField.value.length < 8) {
        e.preventDefault();
        alert("Password must be at least 8 characters.");
        passwordField.focus();
        return false;
      }

      // Validate amount (if amount field exists)
      if (amountField && isNaN(amountField.value)) {
        e.preventDefault();
        alert("Amount must be a valid number.");
        amountField.focus();
        return false;
      }
    });
  });

  // Email validation function
  function validateEmail(email) {
    const regex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
    return regex.test(email);
  }
});