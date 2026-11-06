import { ref as c } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as f } from "vue";
import { createBlock as g } from "vue";
import { withCtx as o } from "vue";
import { withDirectives as k } from "vue";
import { unref as d } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as a } from "vue";
import { isRef as D } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElImage as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { u as E, o as L, rD as M } from "../../../../../../shared/runtime.js";
const R = { style: { width: "100%", height: "80px" } }, P = { __name: "record-detail", props: { visible: { type: Boolean, default: false }, recordId: { type: Number } }, emits: ["update:visible", "del-success"], setup(_, { emit: w }) {
  const b = w, p = _, { visible: n, handleClose: v } = E({ emit: b, props: p, field: "visible", showHook: B }), { maxHeight: x } = L({ mainBox: ".nesting-record-detail-dlg", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, n), y = c([["project", "parse-project"]]), u = c([]), r = c(false);
  async function B() {
    try {
      r.value = true;
      const s = await M(p.recordId);
      u.value = s;
    } catch (s) {
      console.log(s, "获取零件套料明细报错");
    } finally {
      r.value = false;
    }
  }
  return (s, m) => {
    const l = I, H = j, V = h("common-table"), C = h("common-dialog"), N = q;
    return f(), g(C, { title: "套料明细", customClass: "nesting-record-detail-dlg", modelValue: d(n), "onUpdate:modelValue": m[0] || (m[0] = (e) => D(n) ? n.value = e : null), width: "1400px", "before-close": d(v) }, { default: o(() => [k((f(), g(V, { data: u.value, "data-format": y.value, "max-height": d(x), style: { width: "100%" } }, { default: o(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { "show-overflow-tooltip": true, label: "所属项目>单体>区域", "min-width": "180px", align: "left" }, { default: o(({ row: e }) => [i("span", null, a(e.project) + ">" + a(e.monomer.name) + ">" + a(e.area.name), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "center" }, { default: o(({ row: e }) => [i("span", null, a(e.serialNumber), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "100px", align: "center" }, { default: o(({ row: e }) => [i("span", null, a(e.specification), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", "min-width": "80px", align: "center" }, { default: o(({ row: e }) => [i("span", null, a(e.length), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "material", label: "材质", "min-width": "80px", align: "center" }, { default: o(({ row: e }) => [i("span", null, a(e.material), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "netWeight", label: "单净重(kg)", "min-width": "80px", align: "center" }, { default: o(({ row: e }) => [i("span", null, a(e.netWeight), 1)]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, label: "任务数", width: "80", align: "center" }), t(l, { "show-overflow-tooltip": true, label: "图形", width: "100", align: "center" }, { default: o(({ row: e }) => [i("div", R, [t(H, { style: { width: "100%", height: "100%" }, src: e.picturePath, fit: "scale-down" }, null, 8, ["src"])])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[N, r.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  P as default
};
