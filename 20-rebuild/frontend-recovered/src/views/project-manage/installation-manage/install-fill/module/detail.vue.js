import { ref as f } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as d } from "vue";
import { createBlock as w } from "vue";
import { withCtx as l } from "vue";
import { unref as r } from "vue";
import { createTextVNode as J } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as v } from "vue";
import { withDirectives as K } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as O } from "vue";
import { withModifiers as X } from "vue";
import { isRef as Y } from "vue";
import { ElNotification as Z } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElDescriptionsItem as te } from "element-plus";
import { ElDescriptions as le } from "element-plus";
import { ElForm as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { vLoading as ne } from "element-plus";
import { l as M, _ as se, m as re, u as ie, o as ce, G as D, p as ue, tQ as me, D as de, aw as pe, c9 as fe } from "../../../../../shared/runtime.js";
function _e(s) {
  return M({ module: "project", url: "install-report/list-receivingV2", method: "get", params: s });
}
function ge(s) {
  return M({ module: "project", url: "install-report/saveV2", method: "post", data: s });
}
const ke = { get: _e };
const ye = { class: "head-container" }, be = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, selections: { type: Array, default: () => [] }, queryVO: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success", "del-change"], setup(s, { emit: I }) {
  const { user: N } = re(["user"]), V = I, g = s, T = f(), U = f({}), B = { supplierId: [{ required: true, message: "请选择劳务单位", trigger: ["change", "blur"] }] }, q = { selectQuantity: [{ required: true, message: "请输入数量", trigger: "blur" }, { pattern: fe, message: "数量必须大于0", trigger: "blur" }] }, { visible: y, handleClose: C } = ie({ emit: V, props: g }), { tableValidate: P, wrongCellMask: z } = pe({ rules: q });
  $(y, (i) => {
    i && (c.value = g.selections, c.value.forEach((a) => {
      a.accountingMete = a.selectQuantity * a.netWeight;
    }));
  });
  const c = f([]), x = f(), S = f(false), { maxHeight: F } = ce({ mainBox: ".summary-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, x);
  function H(i, a) {
    c.value.splice(a, 1), V("del-change", i);
  }
  async function L() {
    var a, p, m;
    const { validResult: i } = P(c.value);
    if (i) try {
      const u = (a = c.value) == null ? void 0 : a.map((b) => ({ productId: b.productId, reportQuantity: b.selectQuantity })), k = { productType: (p = g.queryVO) == null ? void 0 : p.productType, projectId: (m = g.queryVO) == null ? void 0 : m.projectId, reportDTOParamList: u };
      await ge(k), Z({ title: "提交成功", type: "success" }), V("success"), C();
    } catch (u) {
      console.log("填报失败", u);
    }
  }
  function Q(i, a) {
    i.accountingMete = i.netWeight * a;
  }
  return (i, a) => {
    const p = h("common-button"), m = ee, u = te, k = le, b = ae, n = oe, R = h("common-input-number"), W = h("common-table"), A = h("common-drawer"), G = ne;
    return d(), w(A, { ref_key: "drawerRef", ref: x, title: "汇总明细表", "close-on-click-modal": false, modelValue: r(y), "onUpdate:modelValue": a[0] || (a[0] = (t) => Y(y) ? y.value = t : null), direction: "rtl", "before-close": r(C), "custom-class": "summary-detail", size: "50%" }, { titleRight: l(() => {
      var t;
      return [r(D)(s.permission.save) ? (d(), w(p, { key: 0, type: "success", size: "default", onClick: L, disabled: !((t = c.value) != null && t.length) }, { default: l(() => a[1] || (a[1] = [J(" 保存 ")])), _: 1, __: [1] }, 8, ["disabled"])) : j("", true)];
    }), content: l(() => [_("div", ye, [e(b, { ref_key: "formRef", ref: T, model: U.value, rules: B }, { default: l(() => [e(k, { column: 3, border: "" }, { default: l(() => [e(u, { "label-class-name": "my-label", label: "项目" }, { default: l(() => [e(m, null, { default: l(() => {
      var t, o;
      return [_("span", null, v(((t = s.globalProject) == null ? void 0 : t.serialNumber) + "-" + ((o = s.globalProject) == null ? void 0 : o.name)), 1)];
    }), _: 1 })]), _: 1 }), e(u, { "label-class-name": "my-label", label: "创建人" }, { default: l(() => [e(m, null, { default: l(() => [_("span", null, v(r(N).name), 1)]), _: 1 })]), _: 1 }), e(u, { "label-class-name": "my-label", label: "创建日期" }, { default: l(() => [e(m, null, { default: l(() => [_("span", null, v(r(ue)(/* @__PURE__ */ new Date(), "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])]), K((d(), w(W, { data: c.value, "max-height": r(F), "cell-class-name": r(z) }, { default: l(() => [e(n, { label: "序号", type: "index", align: "center", width: "60", "show-overflow-tooltip": "" }), e(n, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140" }), s.queryVO.productType === r(me).ENCLOSURE.V ? (d(), E(O, { key: 0 }, [e(n, { key: "length", prop: "length", label: "单长（mm）", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: { sourceRow: t } }) => [e(R, { modelValue: t.selectQuantity, "onUpdate:modelValue": (o) => t.selectQuantity = o, controls: false, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (o) => Q(t, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), e(n, { key: "mete", prop: "mete", label: "总长（m）", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: t }) => {
      var o;
      return [_("span", null, v(t.mete ? (o = t.mete) == null ? void 0 : o.toFixed(r(de).COM_L__M) : 0), 1)];
    }), _: 1 })], 64)) : (d(), E(O, { key: 1 }, [e(n, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: { sourceRow: t } }) => [e(R, { modelValue: t.selectQuantity, "onUpdate:modelValue": (o) => t.selectQuantity = o, controls: false, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (o) => Q(t, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), e(n, { key: "netWeight", prop: "netWeight", label: "单净重", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }), e(n, { key: "accountingMete", prop: "accountingMete", label: "核算量", align: "center", "show-overflow-tooltip": "" })], 64)), r(D)(s.permission.del) ? (d(), w(n, { key: 2, label: "操作", width: "80", align: "center" }, { default: l(({ row: { sourceRow: t }, $index: o }) => [e(p, { size: "default", icon: "el-icon-delete", type: "danger", onClick: X((we) => H(t, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : j("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[G, S.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, he = se(be, [["__scopeId", "data-v-0a060764"]]), Ce = Object.freeze(Object.defineProperty({ __proto__: null, default: he }, Symbol.toStringTag, { value: "Module" }));
export {
  ke as c,
  Ce as d,
  he as m
};
