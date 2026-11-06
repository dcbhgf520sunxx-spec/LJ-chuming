import { provide as m } from "vue";
import { ref as c } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { unref as n } from "vue";
import { ElCol as l } from "element-plus";
import { ElRow as f } from "element-plus";
import u from "./artifact-type-config/index.vue.js";
import d from "./conversion-rate-config/index.vue.js";
import { fu as C } from "../../../../shared/runtime.js";
import "./artifact-type-config/module/form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "./artifact-type-config/module/editForm.vue.js";
import "./conversion-rate-config/module/form.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "./conversion-rate-config/module/editFrom.vue.js";
const g = { class: "app-container" }, j = { __name: "index", setup(w) {
  m("permission", C);
  const r = c();
  function s(e) {
    r.value = e;
  }
  return (e, x) => {
    const a = l, i = f;
    return p(), _("div", g, [t(i, { gutter: 20 }, { default: o(() => [t(a, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: o(() => [t(n(u), { onCurrentChange: s })]), _: 1 }), t(a, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: o(() => [t(n(d), { artifactCurrentRow: r.value }, null, 8, ["artifactCurrentRow"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  j as default
};
