import { ElMessage as _ } from "element-plus";
import { openBlock as u } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as f } from "vue";
import { withKeys as h } from "vue";
import { ElOption as y } from "element-plus";
import { ElSelect as g } from "element-plus";
import { ElButton as v } from "element-plus";
import { ElInput as w } from "element-plus";
import { _ as b, a0 as x } from "../../../shared/runtime.js";
const V = { name: "RegCompany", data() {
  return { url: "", protocol: "https://" };
}, mounted() {
  this.protocol = window.location.protocol + "//", this.url = window.location.host;
}, methods: { async submit() {
  const l = this.protocol + this.url;
  x(l) ? (await this.$store.dispatch("user/setRequestUrl", l), this.$emit("reg-result", true)) : _.warning({ message: "错误格式的域名", type: "warning" });
} } }, E = { class: "reg-company-container" }, C = { class: "reg-company-content" };
function R(l, e, U, k, o, a) {
  const r = y, p = g, c = v, i = w;
  return u(), d("div", E, [m("div", C, [t(i, { modelValue: o.url, "onUpdate:modelValue": e[1] || (e[1] = (n) => o.url = n), placeholder: "请填写公司域名", class: "input-with-select", onKeyup: h(a.submit, ["enter"]) }, { prepend: s(() => [t(p, { modelValue: o.protocol, "onUpdate:modelValue": e[0] || (e[0] = (n) => o.protocol = n), placeholder: "请选择" }, { default: s(() => [t(r, { label: "https://", value: "https://" }), t(r, { label: "http://", value: "http://" })]), _: 1 }, 8, ["modelValue"])]), append: s(() => [t(c, { style: { color: "#ffffff" }, onClick: a.submit }, { default: s(() => e[2] || (e[2] = [f("确认")])), _: 1, __: [2] }, 8, ["onClick"])]), _: 1 }, 8, ["modelValue", "onKeyup"])])]);
}
const N = b(V, [["render", R], ["__scopeId", "data-v-bde5c8a9"]]);
export {
  N as default
};
