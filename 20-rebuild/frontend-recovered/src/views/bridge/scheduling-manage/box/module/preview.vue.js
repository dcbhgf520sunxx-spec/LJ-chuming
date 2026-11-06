import { ref as y } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as I } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as B } from "vue";
import { unref as d } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as N } from "vue";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { s as S } from "../../../../../modules/box-3fab54f9.js";
import { u as R, o as W } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/index-6a17f241.js";
const z = { __name: "preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, productType: { type: [Number, String] } }, emits: ["update:visible", "success"], setup(p, { emit: w }) {
  const f = w, g = p, x = y([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), u = y(false), { visible: s, handleClose: h } = R({ emit: f, props: g, field: "visible" }), { maxHeight: v } = W({ mainBox: ".box-scheduling-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, s);
  async function k() {
    try {
      u.value = true;
      const n = g.list.map((e) => {
        var r, o;
        return { askCompleteTime: e.askCompleteTime, factoryId: e.factoryId, groupsId: e.groupsId, productId: e.productId, quantity: e.needSchedulingQuantity, productionLineId: (r = e.productionLine) == null ? void 0 : r.id, workshopId: (o = e.workshop) == null ? void 0 : o.id };
      });
      await S(n), H({ title: "分段排产保存成功", type: "success", duration: 2500 }), h(), f("success");
    } catch (n) {
      console.log("保存分段排产报错", n);
    } finally {
      u.value = false;
    }
  }
  return (n, e) => {
    const r = m("common-button"), o = L, C = m("common-table"), T = m("common-dialog");
    return I(), V(T, { title: "分段排产预览", "custom-class": "box-scheduling-preview", modelValue: d(s), "onUpdate:modelValue": e[0] || (e[0] = (t) => N(s) ? s.value = t : null), width: "1100px", top: "10vh", "before-close": d(h) }, { titleRight: l(() => [a(r, { onClick: k, loading: u.value, size: "default", type: "primary" }, { default: l(() => e[1] || (e[1] = [B("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: l(() => [a(C, { data: p.list, "data-format": x.value, "max-height": d(v), style: { width: "100%" } }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(d(E), { productType: p.productType, fixedWidth: "" }, null, 8, ["productType"]), a(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单净重(kg)", "min-width": "80px", align: "center" }, { default: l(({ row: t }) => [c("span", null, i(t.netWeight), 1)]), _: 1 }), a(o, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", width: "80", align: "center" }), a(o, { prop: "groupsName", "show-overflow-tooltip": true, label: "车间>生产线>生产组", "min-width": "150" }, { default: l(({ row: t }) => {
      var b, _;
      return [c("span", null, i((b = t.workshop) == null ? void 0 : b.name) + ">" + i((_ = t.productionLine) == null ? void 0 : _.name) + ">" + i(t.groupsName), 1)];
    }), _: 1 }), a(o, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", width: "100" }, { default: l(({ row: t }) => [c("span", null, i(t.askCompleteTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  z as default
};
