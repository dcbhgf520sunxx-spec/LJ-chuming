import { ref as c } from "vue";
import g from "moment";
import { onMounted as x } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as a } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as j } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as n } from "vue";
import { unref as _ } from "vue";
import { ElDatePicker as V } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { vLoading as N } from "element-plus";
import { l as z, o as E, z as H } from "../../../shared/runtime.js";
function L(u) {
  return z({ url: "/api/operational/analysis/cost", method: "get", params: u });
}
const M = { class: "app-container" }, P = { class: "head-container" }, T = { class: "project-name" }, O = { __name: "index", setup(u) {
  const { maxHeight: h } = E();
  function v(s) {
    return s > /* @__PURE__ */ new Date();
  }
  const p = c(g().valueOf()), i = c(false), d = c([]);
  x(() => {
    f();
  });
  async function f() {
    try {
      i.value = true;
      const { content: s } = await L({ dateTime: p.value });
      d.value = s;
    } catch (s) {
      console.log(s, "获取项目直接成本");
    } finally {
      i.value = false;
    }
  }
  return (s, r) => {
    const y = V, o = B, w = k("common-table"), b = N;
    return m(), C("div", M, [t("div", P, [a(y, { modelValue: p.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => p.value = e), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "x", clearable: false, "disabled-date": v, onChange: f }, null, 8, ["modelValue"]), r[1] || (r[1] = t("div", { style: { float: "right", "font-size": "16px", color: "#303133" } }, "单位：万元", -1))]), D((m(), j(w, { data: d.value, "max-height": _(h), style: { width: "100%" } }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "120" }, { default: l(({ row: e }) => [t("span", T, n(_(H)(e.project, null, false)), 1)]), _: 1 }), a(o, { prop: "type", "show-overflow-tooltip": true, label: "订单类型" }, { default: l(({ row: e }) => [t("span", null, n(e.type), 1)]), _: 1 }), a(o, { prop: "type", "show-overflow-tooltip": true, label: "状态" }, { default: l(({ row: e }) => [t("span", null, n(e.type), 1)]), _: 1 }), a(o, { prop: "type", "show-overflow-tooltip": true, label: "收入" }, { default: l(({ row: e }) => [t("span", null, n(e.type), 1)]), _: 1 }), a(o, { prop: "type", "show-overflow-tooltip": true, label: "支出" }, { default: l(({ row: e }) => [t("span", null, n(e.type), 1)]), _: 1 }), a(o, { prop: "type", "show-overflow-tooltip": true, label: "预估利润" }, { default: l(({ row: e }) => [t("span", null, n(e.type), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[b, i.value]])]);
  };
} };
export {
  O as default
};
