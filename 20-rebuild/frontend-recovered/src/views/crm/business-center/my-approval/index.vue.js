import { ref as d } from "vue";
import { resolveComponent as n } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as b } from "vue";
import { unref as p } from "vue";
import { ElTableColumn as f } from "element-plus";
import g from "./module/audit-detail.vue.js";
import { x as w } from "../../../../shared/runtime.js";
import h from "./module/header.vue.js";
const x = { class: "app-container" }, E = { __name: "index", setup(V) {
  const { crud: i } = w({ title: "我的审批" }), a = d(false);
  function c() {
    a.value = true;
  }
  return (v, l) => {
    const r = n("common-button"), t = f, m = n("common-table");
    return _(), u("div", x, [e(h), e(r, { onClick: c }, { default: o(() => l[1] || (l[1] = [b("detail")])), _: 1, __: [1] }), e(m, { data: p(i).data }, { default: o(() => [e(t, { type: "index", align: "center", label: "序号", width: "60" }), e(t, { align: "center", label: "日期", width: "150" }), e(t, { align: "center", label: "类型", width: "150" }), e(t, { align: "center", label: "编号", width: "150" }), e(t, { align: "center", label: "登记人", width: "150" }), e(t, { align: "center", label: "部门", width: "150" }), e(t, { align: "center", label: "编号", width: "150" }), e(t, { align: "center", label: "客户名称/项目名称" }), e(t, { align: "center", label: "状态", width: "150" }), e(t, { align: "center", label: "操作" })]), _: 1 }, 8, ["data"]), e(g, { modelValue: a.value, "onUpdate:modelValue": l[0] || (l[0] = (s) => a.value = s) }, null, 8, ["modelValue"])]);
  };
} };
export {
  E as default
};
