import { ref as x } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as w } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as j } from "vue";
import { unref as u } from "vue";
import { isRef as V } from "vue";
import { ElNotification as N } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { l as y, u as B, o as C, ba as I } from "../../../../shared/runtime.js";
function S(n) {
  return y({ module: "project", url: "install-report/list-receiving", method: "get", params: n });
}
function H(n) {
  return y({ module: "project", url: "install-report/save", method: "post", data: n });
}
const q = { get: S }, R = { __name: "detail-confirm", props: { modelValue: { type: Boolean, require: true }, projectId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, submitList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "success"], setup(n, { emit: b }) {
  const m = b, o = n, { visible: l, handleClose: p } = B({ emit: m, props: o }), d = x(), { maxHeight: f } = C({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, d);
  function g(i) {
    return I(i, { props: ["reportQuantity"] });
  }
  async function _(i) {
    try {
      const a = [];
      o.submitList.map((e) => {
        a.push({ productId: e.productId, reportQuantity: e.reportQuantity });
      });
      const s = { projectId: o.projectId, productType: o.productType, reportDTOParamList: a };
      await H(s), N({ title: "提交成功", type: "success" }), m("success"), p();
    } catch (a) {
      console.log("安装填报保存", a);
    }
  }
  return (i, a) => {
    const s = c("common-button"), e = T, k = c("common-table"), h = c("common-drawer");
    return w(), Q(h, { ref_key: "drawerRef", ref: d, title: "提交预览", "close-on-click-modal": false, modelValue: u(l), "onUpdate:modelValue": a[0] || (a[0] = (v) => V(l) ? l.value = v : null), direction: "rtl", "before-close": u(p), "custom-class": "delivery-detail", size: "80%" }, { titleRight: r(() => [t(s, { type: "success", size: "default", onClick: _ }, { default: r(() => a[1] || (a[1] = [j("保存")])), _: 1, __: [1] })]), content: r(() => [t(k, { data: n.submitList, "show-summary": "", "summary-method": g, "max-height": u(f) }, { default: r(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }), t(e, { key: "area.name", prop: "area.name", label: "区域", align: "center" }), t(e, { key: "name", prop: "name", label: "名称", align: "center" }), t(e, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), t(e, { key: "specification", prop: "specification", label: "规格", align: "center" }), t(e, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), t(e, { key: "quantity", prop: "quantity", label: "清单数", align: "center" }), t(e, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), t(e, { key: "mete", prop: "mete", label: "清单量", align: "center" }), t(e, { key: "receivingQuantity", prop: "receivingQuantity", label: "收货量", align: "center" }), t(e, { key: "installQuantity", prop: "installQuantity", label: "已安装量", align: "center" }), t(e, { key: "reportQuantity", prop: "reportQuantity", label: "本次安装填报", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, z = Object.freeze(Object.defineProperty({ __proto__: null, default: R }, Symbol.toStringTag, { value: "Module" }));
export {
  R as _,
  q as c,
  z as d
};
