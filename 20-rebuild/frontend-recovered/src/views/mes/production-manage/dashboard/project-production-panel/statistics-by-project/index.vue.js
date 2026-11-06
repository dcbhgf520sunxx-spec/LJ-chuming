import { n4 as e, j0 as a } from "../../../../../../shared/runtime.js";
import { defineAsyncComponent as s } from "vue";
import { ref as _ } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as p } from "vue";
import { unref as u } from "vue";
import { createBlock as v } from "vue";
import { resolveDynamicComponent as V } from "vue";
const f = { style: { overflow: "hidden" } }, E = { style: { "margin-bottom": "10px" }, class: "toggle-container" }, D = { __name: "index", setup(y) {
  const r = { [e.FORM.V]: s(() => a(() => import("./module/form-panel.vue.js"), ["static/js/form-panel-c6bce316.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/form-header-64f37f4b.js", "static/js/panel-echarts-34d16adb.js", "static/js/use-chart-59e4b63c.js", "static/js/index-18acf776.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/css/panel-echarts-abfe39ef.css", "static/js/workshop-cascader-29b4e914.js", "static/js/project-production-statistics-850038ba.js", "static/js/production-status-13a1f4ef.js", "static/js/project-production-panel-fb6946a2.js", "static/css/production-status-f456d919.css", "static/css/form-header-12481c21.css", "static/js/process-detail-d5dee067.js", "static/js/shipping-table-f16c2b70.js", "static/js/reported-detail-28988d56.js", "static/js/inspection-table-d8d42e2f.js", "static/css/process-detail-b65253db.css", "static/css/form-panel-ec9f3d82.css"])), [e.CARD.V]: s(() => a(() => import("./module/card-panel.vue.js"), ["static/js/card-panel-70a1beb6.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/el-infinite-scroll-4ed993c7.js", "static/js/card-header-577719ff.js", "static/js/index-d6a37d29.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/css/index-9d794dc3.css", "static/js/index-21d3d7d7.js", "static/css/index-7feec4c5.css", "static/js/use-dashboard-header-292e247c.js", "static/js/index-8356a01a.js", "static/css/index-cef9b0a6.css", "static/js/artifact-card-detail-d158f4e9.js", "static/js/process-card-detail-47e276e3.js", "static/js/project-production-panel-fb6946a2.js", "static/css/process-card-detail-fbebd6c9.css", "static/css/artifact-card-detail-abe5009f.css", "static/js/use-dashboard-index-3294c6d4.js", "static/js/raf-ac2cc4f2.js", "static/css/card-panel-e24ac490.css"])) }, o = _(e.FORM.V);
  return (R, n) => {
    const m = c("common-radio-button");
    return l(), d("div", f, [t("div", null, [t("div", E, [p(m, { modelValue: o.value, "onUpdate:modelValue": n[0] || (n[0] = (i) => o.value = i), options: u(e).ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"])]), t("div", null, [(l(), v(V(r[o.value])))])])]);
  };
} };
export {
  D as default
};
