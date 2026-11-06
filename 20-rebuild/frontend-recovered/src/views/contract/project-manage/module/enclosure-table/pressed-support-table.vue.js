import { ref as y } from "vue";
import { watch as k } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as m } from "vue";
import { createBlock as f } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTableColumn as D } from "element-plus";
const S = { __name: "pressed-support-table", props: { tableData: { type: Array, default: () => [] }, isShow: { type: Boolean, default: true } }, emits: ["edit"], setup(i, { emit: w }) {
  const u = i, p = y([]), b = w;
  k(() => u.tableData, (r) => {
    p.value = u.tableData;
  }, { deep: true, immediate: true });
  function h(r) {
    p.value.splice(r, 1);
  }
  function _(r, s) {
    b("edit", s), p.value.splice(r, 1);
  }
  return (r, s) => {
    const l = D, c = d("common-button"), g = d("common-table");
    return m(), f(g, { data: i.tableData, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: o(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "plateType", "show-overflow-tooltip": true, align: "center", label: "板型" }, { default: o((e) => [a("span", null, n(e.row.plateType), 1)]), _: 1 }), t(l, { prop: "unfoldedWidth", "show-overflow-tooltip": true, align: "center", label: "展宽(mm)" }, { default: o((e) => [a("span", null, n(e.row.unfoldedWidth), 1)]), _: 1 }), t(l, { prop: "effectiveWidth", "show-overflow-tooltip": true, align: "center", label: "有效宽(mm)" }, { default: o((e) => [a("span", null, n(e.row.effectiveWidth), 1)]), _: 1 }), t(l, { prop: "mode", "show-overflow-tooltip": true, align: "center", label: "类型" }, { default: o((e) => [a("span", null, n(e.row.mode), 1)]), _: 1 }), t(l, { prop: "thickness", "show-overflow-tooltip": true, align: "center", label: "板厚(mm)" }, { default: o((e) => [a("span", null, n(e.row.thickness), 1)]), _: 1 }), t(l, { prop: "yieldStrength", "show-overflow-tooltip": true, align: "center", label: "屈服强度" }, { default: o((e) => [a("span", null, n(e.row.yieldStrength), 1)]), _: 1 }), t(l, { prop: "brand", "show-overflow-tooltip": true, align: "center", label: "品牌" }, { default: o((e) => [a("span", null, n(e.row.brand), 1)]), _: 1 }), t(l, { prop: "plating", "show-overflow-tooltip": true, align: "center", label: "镀层(g)" }, { default: o((e) => [a("span", null, n(e.row.plating), 1)]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量(m)" }, { default: o((e) => [a("span", null, n(e.row.quantity), 1)]), _: 1 }), i.isShow ? C("", true) : (m(), f(l, { key: 0, label: "操作", align: "center" }, { default: o((e) => [t(c, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (v) => _(e.$index, e.row) }, null, 8, ["onClick"]), t(c, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (v) => h(e.$index) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data"]);
  };
} };
export {
  S as default
};
