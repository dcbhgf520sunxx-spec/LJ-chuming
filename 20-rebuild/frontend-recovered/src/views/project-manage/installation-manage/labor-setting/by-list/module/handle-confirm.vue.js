import { ref as f } from "vue";
import { computed as O } from "vue";
import { watch as W } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as y } from "vue";
import { createBlock as v } from "vue";
import { withCtx as t } from "vue";
import { unref as r } from "vue";
import { createTextVNode as $ } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as w } from "vue";
import { withDirectives as A } from "vue";
import { isRef as K } from "vue";
import { ElNotification as J } from "element-plus";
import { ElFormItem as X } from "element-plus";
import { ElDescriptionsItem as Y } from "element-plus";
import { ElDescriptions as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { ElTableColumn as ae } from "element-plus";
import { vLoading as te } from "element-plus";
import { s as le } from "../../../../../../modules/labor-setting-a0cbdb82.js";
import { _ as ne, m as oe, D as se, u as ie, o as re, G as N, p as ce, aw as ue } from "../../../../../../shared/runtime.js";
import { _ as de } from "../../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const me = { class: "head-container" }, pe = { __name: "handle-confirm", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, globalProjectId: { type: Number, default: void 0 }, selections: { type: Array, default: () => [] }, productType: { type: [Number, String], default: void 0 }, areaId: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success", "del-change"], setup(d, { emit: P }) {
  const { user: R } = oe(["user"]), I = P, n = d, D = f(), p = f({ supplierId: void 0 }), B = O(() => [["accountingMete", ["to-thousand", se.COM_WT__KG]]]), E = { supplierId: [{ required: true, message: "请选择劳务单位", trigger: ["change", "blur"] }] }, M = { canDivideQuantity: [{ required: true, message: "请填写数量", trigger: ["blur", "change"] }, { validator: (u, a) => !(!a.canDivideQuantity || a.maxNumerical < 1), message: "请填写数值并且最小数值为1", trigger: "blur" }] }, { visible: b, handleClose: x } = ie({ emit: I, props: n, closeHook: C }), { tableValidate: Q, wrongCellMask: T } = ue({ rules: M });
  W(b, (u) => {
    var a;
    u && (c.value = n.selections, (a = c.value) == null || a.forEach((o) => {
      o.accountingMete = o.canDivideQuantity * o.netWeight;
    }));
  });
  const c = f([]), V = f(), H = f(false), { maxHeight: U } = re({ mainBox: ".summary-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, V);
  function q(u, a) {
    c.value.splice(a, 1), I("del-change", u);
  }
  function C() {
    p.value.supplierId = void 0;
  }
  async function S() {
    var o;
    const u = await D.value.validate(), { validResult: a } = Q(c.value);
    if (!(!u || !a)) try {
      const i = (o = c.value) == null ? void 0 : o.map((_) => ({ productId: _.productId, quantity: _.canDivideQuantity })), m = { productType: n == null ? void 0 : n.productType, areaId: n == null ? void 0 : n.areaId, supplierId: p.value.supplierId, projectId: n.globalProjectId, productParamList: i };
      await le(m), J({ title: "提交成功", type: "success" }), I("success"), x(), C();
    } catch (i) {
      console.log("审核", i);
    }
  }
  return (u, a) => {
    const o = k("common-button"), i = X, m = Y, _ = Z, z = ee, s = ae, F = k("common-table"), L = k("common-drawer"), G = te;
    return y(), v(L, { ref_key: "drawerRef", ref: V, title: "汇总明细表", "close-on-click-modal": false, modelValue: r(b), "onUpdate:modelValue": a[1] || (a[1] = (l) => K(b) ? b.value = l : null), direction: "rtl", "before-close": r(x), "custom-class": "summary-detail", size: "70%" }, { titleRight: t(() => {
      var l;
      return [r(N)(d.permission.save) ? (y(), v(o, { key: 0, disabled: !((l = c.value) != null && l.length), type: "success", size: "default", onClick: S }, { default: t(() => a[2] || (a[2] = [$("保存")])), _: 1, __: [2] }, 8, ["disabled"])) : j("", true)];
    }), content: t(() => [h("div", me, [e(z, { ref_key: "formRef", ref: D, model: p.value, rules: E }, { default: t(() => [e(_, { column: 2, border: "" }, { default: t(() => [e(m, { "label-class-name": "my-label", label: "项目" }, { default: t(() => [e(i, null, { default: t(() => {
      var l, g;
      return [h("span", null, w(((l = d.globalProject) == null ? void 0 : l.serialNumber) + "-" + ((g = d.globalProject) == null ? void 0 : g.name)), 1)];
    }), _: 1 })]), _: 1 }), e(m, { "label-class-name": "my-label", label: "选择劳务单位" }, { default: t(() => [e(i, { prop: "supplierId" }, { default: t(() => [e(de, { modelValue: p.value.supplierId, "onUpdate:modelValue": a[0] || (a[0] = (l) => p.value.supplierId = l), projectId: d.globalProjectId, clearable: "", placeholder: "选择劳务单位", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "projectId"])]), _: 1 })]), _: 1 }), e(m, { "label-class-name": "my-label", label: "创建人" }, { default: t(() => [e(i, null, { default: t(() => {
      var l;
      return [h("span", null, w((l = r(R)) == null ? void 0 : l.name), 1)];
    }), _: 1 })]), _: 1 }), e(m, { "label-class-name": "my-label", label: "创建日期" }, { default: t(() => [e(i, null, { default: t(() => [h("span", null, w(r(ce)(/* @__PURE__ */ new Date(), "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), A((y(), v(F, { data: c.value, returnSourceData: "", "max-height": r(U), "data-format": B.value, "cell-class-name": r(T) }, { default: t(() => [e(s, { label: "序号", type: "index", align: "center", width: "60" }), e(s, { key: "name", prop: "name", label: "名称", align: "center" }), e(s, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), e(s, { key: "specification", prop: "specification", label: "规格", align: "center" }), e(s, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), e(s, { key: "canDivideQuantity", prop: "canDivideQuantity", label: "数量", align: "center" }), e(s, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), e(s, { key: "accountingMete", prop: "accountingMete", label: "核算量", align: "center" }), r(N)(d.permission.del) ? (y(), v(s, { key: 0, label: "操作", align: "center" }, { default: t(({ row: l, $index: g }) => [e(o, { type: "danger", size: "default", icon: "el-icon-delete", class: "filter-item", onClick: (be) => q(l, g) }, null, 8, ["onClick"])]), _: 1 })) : j("", true)]), _: 1 }, 8, ["data", "max-height", "data-format", "cell-class-name"])), [[G, H.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, he = ne(pe, [["__scopeId", "data-v-fefb43b9"]]);
export {
  he as default
};
