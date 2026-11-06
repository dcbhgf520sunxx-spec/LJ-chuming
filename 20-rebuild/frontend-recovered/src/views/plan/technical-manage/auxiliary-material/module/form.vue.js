import { _ as b, ao as g, i as m } from "../../../../../shared/runtime.js";
import h from "./auxiliary-material-form.vue.js";
import { inject as a } from "vue";
import { computed as w } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as o } from "vue";
import { createBlock as p } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as s } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as r } from "vue";
import { unref as e } from "vue";
import { createElementBlock as _ } from "vue";
import { createCommentVNode as d } from "vue";
import { resolveDynamicComponent as k } from "vue";
import "./material/common-wrapper.vue.js";
import "../../../../wms/material-inbound/raw-material/application/components/common-footer.vue.js";
import "./material/confirm-dialog.vue.js";
import "./material/aux-mat-table.vue.js";
const N = { style: { "margin-left": "5px" } }, A = { key: 0, style: { "margin-left": "10px" } }, B = { key: 1, style: { "margin-left": "10px" } }, D = { __name: "form", setup(M) {
  const { crud: t, form: f } = g(), c = a("currentMonomer"), n = a("currentArea"), l = a("globalProject"), v = w(() => h);
  function x() {
    t.cancelCU(), t.refresh();
  }
  return (S, i) => {
    const y = C("common-drawer");
    return o(), p(y, { ref: "drawerRef", visible: e(t).status.cu > 0, "before-close": e(t).cancelCU, title: e(t).status.title, "show-close": true, "wrapper-closable": false, size: "90%", "custom-class": "raw-mat-inbound-application-record-form" }, { titleAfter: u(() => [s("div", null, [i[0] || (i[0] = j("项目:")), s("span", null, r(e(l).serialNumber), 1), s("span", N, r(e(l).shortName), 1)]), e(m)(e(c)) ? (o(), _("div", A, "单体:" + r(e(c).name), 1)) : d("", true), e(m)(e(n)) ? (o(), _("div", B, "区域:" + r(e(n).name), 1)) : d("", true)]), content: u(() => [(o(), p(k(v.value), { detail: e(f), onSuccess: x, project: e(t).query }, null, 40, ["detail", "project"]))]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, I = b(D, [["__scopeId", "data-v-accd09da"]]);
export {
  I as default
};
