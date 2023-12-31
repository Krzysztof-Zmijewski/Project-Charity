document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
  const hiddenInput = document.getElementsByName("_categories");
  for (let i = hiddenInput.length - 1; i >= 0; i--) {
    hiddenInput[i].remove();
  }
// Number of bags in summary
  const bags = document.querySelector("#formQuantity");
  const bagsQuantity = document.querySelector("#donationQuantity");
  bags.addEventListener("keyup", () => {
    if(bags.value === 1) {
      bagsQuantity.innerText = bags.value + " worek " + category;
    }
    if(bags.value > 1 && bags.value < 5) {
      bagsQuantity.innerText = bags.value + " worki " + category;
    }
    if(bags.value >= 5) {
      bagsQuantity.innerText = bags.value + " worków " + category;
    }
  })
  //Category in summary
  const categories = document.querySelectorAll("#categories");
  let category = "";
  categories.forEach(el => {
    el.addEventListener("click", () => {
      category += el.nextSibling.nextSibling.nextSibling.nextSibling.textContent + ",";
    })
  })
  //Institution in summary
  const donationInstitution = document.querySelector("#donationInstitution");
  const institution = document.querySelectorAll("#organization");
  institution.forEach(el => {
    el.addEventListener("click", () => {
      donationInstitution.innerText = el.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.textContent;
    })
  })
  // Street summary
  const streetSummary = document.querySelector("#donationStreet");
  const street = document.querySelector("#street");
  street.addEventListener("keyup", () => {
    streetSummary.innerText = street.value;
  })
  //City summary
  const citySummary = document.querySelector("#donationCity");
  const city = document.querySelector("#city");
  city.addEventListener("keyup", () => {
    citySummary.innerText = city.value;
  })
  //ZipCode summary
  const zipCodeSummary = document.querySelector("#donationZipCode");
  const zipCode = document.querySelector("#zipCode");
  zipCode.addEventListener("keyup", () => {
    zipCodeSummary.innerText = zipCode.value;
  })
  // PhoneNumber summary
  const phoneNumberSummary = document.querySelector("#donationPhoneNumber");
  const phoneNumber = document.querySelector("#phoneNumber");
  phoneNumber.addEventListener("keyup", () => {
    phoneNumberSummary.innerText = phoneNumber.value;
  })
  //PickUpDate summary
  const pickUpDateSummary = document.querySelector("#donationPickUpDate");
  const pickUpDate = document.querySelector("#pickUpDate");
  pickUpDate.addEventListener("click", () => {
    pickUpDateSummary.innerText = pickUpDate.value;
  })
  //PickUpTime summary
  const pickUpTimeSummary = document.querySelector("#donationPickUpTime");
  const pickUpTime = document.querySelector("#pickUpTime");
  pickUpTime.addEventListener("click", () => {
    pickUpDateSummary.innerText = pickUpDate.value;
  })
  //PickUpDescription summary
  const pickUpDescriptionSummary = document.querySelector("#donationDescription");
  const pickUpDescription = document.querySelector("#pickUpComment");
  pickUpDescription.addEventListener("keyup", () => {
    pickUpDescriptionSummary.innerText = pickUpDescription.value;
  })
});
