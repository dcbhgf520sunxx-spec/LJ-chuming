import { ref as w } from "vue";
import { inject as B } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as C } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as j } from "vue";
import { unref as d } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { isRef as q } from "vue";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { s as L } from "../../../../../modules/machine-part-b1b959c2.js";
import { u as M, o as I } from "../../../../../shared/runtime.js";
const W = { __name: "preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(m, { emit: _ }) {
  const f = _, h = m, v = w([["project", "parse-project"]]), p = w(false), g = B("crud"), { visible: s, handleClose: b } = M({ emit: f, props: h, field: "visible" }), { maxHeight: x } = I({ mainBox: ".machine-part-scheduling-preview-dlg", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, s);
  async function y() {
    try {
      p.value = true;
      const i = [];
      h.list.forEach((o) => {
        o.needMachinePartLinkList.forEach((n) => {
          i.push({ productId: o.id, quantity: n.quantity, id: n.id, needSchedulingMonth: n.date });
        });
      }), await L({ material: g.query.material, thick: g.query.thick, linkList: i }), H({ title: "零件排产保存成功", type: "success", duration: 2500 }), b(), f("success");
    } catch (i) {
      console.log("保存零件排产报错", i);
    } finally {
      p.value = false;
    }
  }
  return (i, o) => {
    const n = u("common-button"), l = E, k = u("common-table"), V = u("common-dialog");
    return C(), N(V, { customClass: "machine-part-scheduling-preview-dlg", title: "零件排产预览", modelValue: d(s), "onUpdate:modelValue": o[0] || (o[0] = (e) => q(s) ? s.value = e : null), width: "1100px", "before-close": d(b) }, { titleRight: a(() => [t(n, { onClick: y, loading: p.value, size: "default", type: "primary" }, { default: a(() => o[1] || (o[1] = [j("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: a(() => [t(k, { data: m.list, "data-format": v.value, "max-height": d(x), style: { width: "100%" } }, { default: a(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { "show-overflow-tooltip": true, prop: "project", label: "所属项目", "min-width": "120px", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "center" }, { default: a(({ row: e }) => [r("span", null, c(e.serialNumber), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "80px", align: "center" }, { default: a(({ row: e }) => [r("span", null, c(e.specification), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", "min-width": "80px", align: "center" }, { default: a(({ row: e }) => [r("span", null, c(e.length), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "netWeight", label: "单净重(kg)", "min-width": "80px", align: "center" }, { default: a(({ row: e }) => [r("span", null, c(e.netWeight), 1)]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", width: "80", align: "center" })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  W as default
};
