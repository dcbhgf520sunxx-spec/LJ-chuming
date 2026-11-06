import { pS as e, o as p, j0 as t } from "../../../../../../shared/runtime.js";
import { defineAsyncComponent as a } from "vue";
import { ref as u } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as V } from "vue";
import { unref as i } from "vue";
import { createBlock as g } from "vue";
import { resolveDynamicComponent as h } from "vue";
const E = { class: "wrap-content" }, f = { style: { "margin-bottom": "10px" }, class: "toggle-container" }, b = { __name: "tab-table", setup(P) {
  const m = { [e.PRODUCTION.V]: a(() => t(() => import("../components/production-component.vue.js"), ["static/js/production-component-c4cba82e.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/workshop-cascader-3ff3a76f.js", "static/js/project-production-statistics-850038ba.js"])), [e.TEAM_GROUP.V]: a(() => t(() => import("../components/team-group-component.vue.js"), ["static/js/team-group-component-be753bd6.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/workshop-cascader-3ff3a76f.js", "static/js/project-production-statistics-850038ba.js", "static/js/process-select-1b019953.js"])), [e.PICK_LIST.V]: a(() => t(() => import("../components/pick-list-component.vue.js"), ["static/js/pick-list-component-30747684.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-c07af747.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/project-material-c2039d20.js", "static/css/pick-list-component-47c8d413.css"])) }, o = u(e.PRODUCTION.V), { maxHeight: _ } = p({ paginate: false, navbar: true, minHeight: 200, extraHeight: 420 });
  return (x, n) => {
    const l = d("common-radio-button");
    return s(), v("div", E, [r("div", f, [V(l, { modelValue: o.value, "onUpdate:modelValue": n[0] || (n[0] = (c) => o.value = c), options: i(e).ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"])]), r("div", null, [(s(), g(h(m[o.value]), { "max-height": i(_) }, null, 8, ["max-height"]))])]);
  };
} };
export {
  b as default
};
