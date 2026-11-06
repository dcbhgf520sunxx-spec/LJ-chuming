import { ref as b } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as I } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as B } from "vue";
import { unref as d } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as N } from "vue";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { s as L } from "../../../../../modules/artifact-f1b0ca44.js";
import { u as S, o as R } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/index-490fd9d7.js";
const z = { __name: "preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, productType: { type: [Number, String] } }, emits: ["update:visible", "success"], setup(u, { emit: y }) {
  const f = y, g = u, x = b([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), m = b(false), { visible: s, handleClose: h } = S({ emit: f, props: g, field: "visible" }), { maxHeight: v } = R({ mainBox: ".artifact-scheduling-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, s);
  async function k() {
    try {
      m.value = true;
      const r = g.list.map((e) => {
        var p, o;
        return { askCompleteTime: e.askCompleteTime, factoryId: e.factoryId, groupsId: e.groupsId, productId: e.productId, quantity: e.needSchedulingQuantity, productionLineId: (p = e.productionLine) == null ? void 0 : p.id, workshopId: (o = e.workshop) == null ? void 0 : o.id };
      });
      await L(r), H({ title: "构件排产保存成功", type: "success", duration: 2500 }), h(), f("success");
    } catch (r) {
      console.log("保存构件排产报错", r);
    } finally {
      m.value = false;
    }
  }
  return (r, e) => {
    const p = c("common-button"), o = W, C = c("common-table"), T = c("common-dialog");
    return I(), V(T, { title: "构件排产预览", "custom-class": "artifact-scheduling-preview", modelValue: d(s), "onUpdate:modelValue": e[0] || (e[0] = (t) => N(s) ? s.value = t : null), width: "1200px", top: "10vh", "before-close": d(h) }, { titleRight: l(() => [a(p, { onClick: k, loading: m.value, size: "default", type: "primary" }, { default: l(() => e[1] || (e[1] = [B("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: l(() => [a(C, { data: u.list, "data-format": x.value, "max-height": d(v), style: { width: "100%" } }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(d(E), { productType: u.productType, fixedWidth: "" }, null, 8, ["productType"]), a(o, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", "min-width": "80px", align: "center" }, { default: l(({ row: t }) => [n("span", null, i(t.length), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "grossWeight", label: "单毛重(kg)", "min-width": "80px", align: "center" }, { default: l(({ row: t }) => [n("span", null, i(t.grossWeight), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单净重(kg)", "min-width": "80px", align: "center" }, { default: l(({ row: t }) => [n("span", null, i(t.netWeight), 1)]), _: 1 }), a(o, { prop: "needSchedulingQuantity", "show-overflow-tooltip": true, label: "数量", width: "80", align: "center" }), a(o, { prop: "groupsName", "show-overflow-tooltip": true, label: "车间>生产线", "min-width": "150" }, { default: l(({ row: t }) => {
      var w, _;
      return [n("span", null, i((w = t.workshop) == null ? void 0 : w.name) + ">" + i((_ = t.productionLine) == null ? void 0 : _.name), 1)];
    }), _: 1 }), a(o, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", width: "100" }, { default: l(({ row: t }) => [n("span", null, i(t.askCompleteTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  z as default
};
