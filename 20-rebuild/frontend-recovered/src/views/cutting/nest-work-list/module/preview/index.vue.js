import { ref as g } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as x } from "vue";
import { createBlock as I } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as V } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { unref as p } from "vue";
import { isRef as C } from "vue";
import { ElTableColumn as N } from "element-plus";
import { _ as B, u as q } from "../../../../../shared/runtime.js";
const D = { class: "flex-rss" }, H = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Array, required: true }, selectLine: { type: Object, required: true } }, emits: ["update:visible"], setup(c, { emit: _ }) {
  const d = c, i = _, m = g(""), { visible: r, handleClose: f } = q({ emit: i, props: d, field: "visible", closeHook: h, showHook: w });
  function w() {
    m.value = d.selectLine.machineName;
  }
  function h() {
    i("closeHook");
  }
  function b() {
    i("taskIssue");
  }
  return (R, s) => {
    const v = u("common-button"), l = N, y = u("common-table"), k = u("common-dialog");
    return x(), I(k, { width: "60%", title: "所选设备: " + m.value, "append-to-body": "", modelValue: p(r), "onUpdate:modelValue": s[0] || (s[0] = (e) => C(r) ? r.value = e : null), "before-close": p(f) }, { titleRight: t(() => [o(v, { size: "default", onClick: b, type: "success" }, { default: t(() => s[1] || (s[1] = [V("任务下发")])), _: 1, __: [1] })]), default: t(() => [a("div", D, [o(y, { ref: "tableRef", data: c.detailData, "max-height": 500, style: { width: "100%" }, "row-key": "id" }, { default: t(() => [o(l, { label: "序号", type: "index", align: "center", width: "60" }), o(l, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100" }, { default: t((e) => [a("span", null, n(e.row.cutInstructionId), 1)]), _: 1 }), o(l, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: t((e) => [a("span", null, n(e.row.material), 1)]), _: 1 }), o(l, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "40" }, { default: t((e) => [a("span", null, n(e.row.thick), 1)]), _: 1 }), o(l, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "40" }, { default: t((e) => [a("span", null, n(e.row.width), 1)]), _: 1 }), o(l, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "40" }, { default: t((e) => [a("span", null, n(e.row.length), 1)]), _: 1 }), o(l, { key: "num", prop: "num", "show-overflow-tooltip": true, label: "数量", "min-width": "30" }, { default: t((e) => [a("span", null, n(e.row.num), 1)]), _: 1 })]), _: 1 }, 8, ["data"])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, T = B(H, [["__scopeId", "data-v-1ccf85ac"]]);
export {
  T as default
};
