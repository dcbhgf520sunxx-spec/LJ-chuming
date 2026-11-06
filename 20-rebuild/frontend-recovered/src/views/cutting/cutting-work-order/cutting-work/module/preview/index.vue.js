import { ref as g } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as x } from "vue";
import { createBlock as I } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as V } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as a } from "vue";
import { unref as C } from "vue";
import { isRef as N } from "vue";
import { ElTableColumn as B } from "element-plus";
import { _ as D, u as q } from "../../../../../../shared/runtime.js";
const H = { class: "flex-rss" }, R = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Array, required: true }, selectLine: { type: Object, required: true } }, emits: ["update:visible"], setup(u, { emit: _ }) {
  const d = u, s = _, m = g(""), { visible: r, handleClose: p } = q({ emit: s, props: d, field: "visible", closeHook: w, showHook: f });
  function f() {
    m.value = d.selectLine.machineName;
  }
  function w() {
    s("closeHook");
  }
  function h() {
    p();
  }
  function b() {
    p(), s("taskIssue");
  }
  return (j, i) => {
    const k = c("common-button"), l = B, v = c("common-table"), y = c("common-dialog");
    return x(), I(y, { width: "60%", title: "所选设备: " + m.value, "append-to-body": "", modelValue: C(r), "onUpdate:modelValue": i[0] || (i[0] = (e) => N(r) ? r.value = e : null), "before-close": h, "close-on-click-modal": false }, { titleRight: t(() => [o(k, { size: "default", onClick: b, type: "success" }, { default: t(() => i[1] || (i[1] = [V("任务分配")])), _: 1, __: [1] })]), default: t(() => [n("div", H, [o(v, { ref: "tableRef", data: u.detailData, "max-height": 500, style: { width: "100%" }, "row-key": "id" }, { default: t(() => [o(l, { label: "序号", type: "index", align: "center", width: "60" }), o(l, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100", align: "center" }, { default: t((e) => [n("span", null, a(e.row.cutInstructionId), 1)]), _: 1 }), o(l, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "40" }, { default: t((e) => [n("span", null, a(e.row.material), 1)]), _: 1 }), o(l, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "40", align: "center" }, { default: t((e) => [n("span", null, a(e.row.thick), 1)]), _: 1 }), o(l, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "40", align: "center" }, { default: t((e) => [n("span", null, a(e.row.width), 1)]), _: 1 }), o(l, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "40", align: "center" }, { default: t((e) => [n("span", null, a(e.row.length), 1)]), _: 1 }), o(l, { key: "num", prop: "num", "show-overflow-tooltip": true, label: "数量", "min-width": "30", align: "center" }, { default: t((e) => [n("span", null, a(e.row.num), 1)]), _: 1 })]), _: 1 }, 8, ["data"])])]), _: 1 }, 8, ["title", "modelValue"]);
  };
} }, z = D(R, [["__scopeId", "data-v-f584f7c6"]]);
export {
  z as default
};
