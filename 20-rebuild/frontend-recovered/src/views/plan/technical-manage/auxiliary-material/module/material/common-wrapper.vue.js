import { _ as m, o as p } from "../../../../../../shared/runtime.js";
import d from "../../../../../wms/material-inbound/raw-material/application/components/common-footer.vue.js";
import c from "./confirm-dialog.vue.js";
import { ref as f } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as y } from "vue";
import { renderSlot as v } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as w } from "vue";
import { unref as x } from "vue";
const g = { class: "main-content" }, h = { __name: "common-wrapper", props: { basicClass: { type: Number }, validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "提交预览" }, showTotal: { type: Boolean, default: true }, edit: { type: Boolean, default: false } }, setup(r) {
  const e = r, a = f(false);
  let o = {};
  e.edit ? o = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false } : o = { extraBox: null, wrapperBox: null };
  const { heightStyle: s } = p(o);
  async function i() {
    let t = true;
    typeof e.validate == "function" && (t = await e.validate()), t && (a.value = true);
  }
  return (t, l) => (_(), b("div", { class: "inbound-application-container", style: w(x(s)) }, [y("div", g, [v(t.$slots, "default", {}, void 0, true)]), n(d, { class: "footer", unit: e.unit, "total-name": e.totalName, "total-value": e.totalValue, "show-total": e.showTotal, "btn-name": e.btnName, onSubmit: i }, null, 8, ["unit", "total-name", "total-value", "show-total", "btn-name"]), n(c, { modelValue: a.value, "onUpdate:modelValue": l[0] || (l[0] = (u) => a.value = u), "basic-class": e.basicClass }, null, 8, ["modelValue", "basic-class"])], 4));
} }, C = m(h, [["__scopeId", "data-v-68d7b0a1"]]);
export {
  C as default
};
