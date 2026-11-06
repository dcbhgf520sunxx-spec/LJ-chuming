import { ref as r } from "vue";
import { watch as D } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as h } from "vue";
import { createBlock as y } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as d } from "vue";
import { withDirectives as I } from "vue";
import { unref as _ } from "vue";
import { createVNode as c } from "vue";
import { isRef as Q } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as M } from "element-plus";
import { t as N } from "../../../../../modules/common-b3e76e54.js";
import { _ as j, u as q, o as z } from "../../../../../shared/runtime.js";
const E = { class: "tip" }, O = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(u, { emit: x }) {
  const g = r(), w = r(), k = x, i = u, { visible: p, handleClose: V } = q({ emit: k, props: i, field: "visible" }), { maxHeight: B } = z({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, w), f = r(false), m = r([]);
  D(() => i.visible, (l) => {
    l ? R() : L();
  }, { immediate: true });
  function L() {
    m.value = [];
  }
  async function R() {
    var e, t;
    let l = [];
    try {
      f.value = true;
      const { content: s } = await N({ productType: (e = i.info) == null ? void 0 : e.productType, productId: (t = i.info) == null ? void 0 : t.productId });
      l = s;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      m.value = l, f.value = false;
    }
  }
  return (l, e) => {
    const t = T, s = v("common-table"), C = v("common-drawer"), H = M;
    return h(), y(C, { ref_key: "drawerRef", ref: w, title: `${u.info.serialNumber}零件详情`, modelValue: _(p), "onUpdate:modelValue": e[0] || (e[0] = (a) => Q(p) ? p.value = a : null), direction: "rtl", "before-close": _(V), size: "40%" }, { content: n(() => [o("div", E, [e[1] || (e[1] = o("span", null, "* 注意：", -1)), o("span", null, " 可修改的零件数量总和为" + d(u.info.canHandleTotalMete) + "，请谨慎操作！", 1)]), I((h(), y(s, { ref_key: "tableRef", ref: g, data: m.value, "max-height": _(B), style: { width: "100%" } }, { default: n(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), c(t, { prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线", "min-width": "150px" }, { default: n((a) => {
      var b;
      return [o("span", null, d((b = a.row.productionLine) == null ? void 0 : b.name), 1)];
    }), _: 1 }), c(t, { prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数", align: "center", width: "100px" }, { default: n((a) => [o("span", null, d(a.row.taskQuantity), 1)]), _: 1 }), c(t, { prop: "completeQuantity", "show-overflow-tooltip": true, label: "已生产", align: "center", width: "100px" }, { default: n((a) => [o("span", null, d(a.row.completeQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, f.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, A = j(O, [["__scopeId", "data-v-8e9fb69d"]]);
export {
  A as default
};
