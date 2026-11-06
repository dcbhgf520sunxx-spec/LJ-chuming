import { ref as y } from "vue";
import { computed as v } from "vue";
import { provide as ge } from "vue";
import { watchEffect as fe } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as m } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as A } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as V } from "vue";
import { createElementVNode as he } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as ye } from "vue";
import { resolveDynamicComponent as _e } from "vue";
import { isRef as Te } from "vue";
import { ElMessage as ve } from "element-plus";
import { ElTag as Ee } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElFormItem as Ie } from "element-plus";
import { ElInputNumber as Ve } from "element-plus";
import { ElForm as Ue } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElPagination as We } from "element-plus";
import { vLoading as Re } from "element-plus";
import { d as Me, e as Ae } from "../../../../../../modules/list-valuation-9a754659.js";
import { _ as Ne, u as Ce, J as Le, o as Pe, kO as b, jm as c, kQ as p, kP as U, iz as q, aw as xe, ba as Se, i as ke } from "../../../../../../shared/runtime.js";
import G from "../components/list-create-table/structure.vue.js";
import He from "../components/list-create-table/enclosure.vue.js";
import qe from "../components/list-create-table/auxiliary-material.vue.js";
const Ge = { key: 0, style: { color: "#999" } }, je = { key: 1 }, ze = { key: 0, style: { "font-size": "13px", color: "#e6a23c" } }, Ye = { __name: "list-edit", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(T, { emit: j }) {
  const C = y(), L = j, s = T, { visible: w, handleClose: P } = Ce({ emit: L, props: s, field: "visible", showHook: ne }), { handleSizeChange: z, handleCurrentChange: Y, total: B, setTotalPage: D, queryPage: I } = Le({ fetchHook: S }), { maxHeight: Q } = Pe({ mainBox: ".list-valuation-list-create-drawer", extraBox: [".el-drawer__header", ".form-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => C.value.loaded), d = v(() => {
    var t;
    return (t = s.detailInfo) == null ? void 0 : t.productType;
  }), x = y(), g = y([]), W = y(false), e = y({}), R = y(false), O = { pricingName: [{ required: true, message: "请输入名称", trigger: "change" }], pricingManner: [{ required: true, message: "请选择计价方式", trigger: "change" }], pricingUnitType: [{ required: true, message: "请选择计价单位", trigger: "change" }], pricingWeightType: [{ required: true, message: "请选择计价重量类型", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }] }, F = { unitPrice: [{ validator: (t, n) => ke(t), message: "请填写单价", trigger: ["blur", "change"] }] }, { tableValidate: X, wrongCellMask: $ } = xe({ rules: F });
  ge("weightType", v(() => {
    var t;
    return ((t = e.value) == null ? void 0 : t.pricingWeightType) || b.NET_WEIGHT.V;
  }));
  const K = { [c.WEIGHT.V]: "totalWeight", [c.QUANTITY.V]: "totalQuantity", [c.AREA.V]: "totalArea", [c.LENGTH.V]: "totalLength" }, J = { [b.NET_WEIGHT.V]: "totalNetWeight", [b.GROSS_WEIGHT.V]: "totalGrossWeight", [b.DRAW_WEIGHT.V]: "drawingTotalWeight" };
  fe(() => {
    const t = g.value.reduce((a, i) => (i.productType === p.STRUCTURE.V ? a.totalWeight += +e.value.pricingWeightType ? i[J[e.value.pricingWeightType]] : i.totalNetWeight : i.productType === p.ENCLOSURE.V && (a.totalWeight += +i.enclosureTotalWeight || 0, a.totalLength += +i.totalLength, a.totalArea += +i.totalArea), a.totalQuantity += +i.quantity, a), { totalWeight: 0, totalArea: 0, totalQuantity: 0, totalLength: 0 });
    let n = e.value.unitPrice;
    e.value.pricingUnitType === U.DUN.V && (n = n / 1e3), n && e.value.pricingManner && (e.value.amount = (n * t[K[e.value.pricingManner]]).toFixed(2));
  });
  const Z = v(() => {
    const t = [];
    return d.value === p.STRUCTURE.V && (t.push(c.WEIGHT), t.push(c.QUANTITY)), d.value === p.ENCLOSURE.V && (t.push(c.WEIGHT), t.push(c.LENGTH), t.push(c.AREA), t.push(c.QUANTITY)), d.value === p.AUXILIARY_MATERIAL.V && t.push(c.QUANTITY), t;
  }), ee = v(() => {
    const t = [];
    return U.KEYS.forEach((a) => {
      U[a].pm === e.value.pricingManner && t.push(U[a]);
    }), t;
  }), te = v(() => {
    switch (d.value) {
      case p.STRUCTURE.V:
        return G;
      case p.ENCLOSURE.V:
        return He;
      case p.AUXILIARY_MATERIAL.V:
        return qe;
      default:
        return G;
    }
  });
  function ae(t) {
    return Se(t, { props: ["quantity", "totalNetWeight", "totalGrossWeight", "drawingTotalWeight", "totalLength", "totalArea", "totalPrice", "enclosureTotalWeight"] });
  }
  async function ne() {
    I.pageNumber = 1, e.value = {}, e.value.pricingName = s.detailInfo.pricingName, e.value.pricingManner = s.detailInfo.pricingMannerEnum, e.value.pricingUnitType = s.detailInfo.pricingUnitTypeEnum, e.value.pricingWeightType = s.detailInfo.pricingWeightTypeEnum, e.value.unitPrice = s.detailInfo.unitPrice, e.value.amount = s.detailInfo.totalPrice, await S();
  }
  async function S() {
    try {
      W.value = true;
      const { content: t = [], totalElements: n } = await Me({ id: s.detailInfo.id, ...I });
      g.value = (t == null ? void 0 : t.map((a) => (a.originQuantity = a.quantity, a.mete = a.pricingMete, a.originMete = a.mete, a.originTotalLength = a.totalLength, a.originTotalArea = a.totalArea, a.enclosureTotalWeight = a.totalWeight, a))) || [], D(n);
    } catch (t) {
      console.log("获取详情", t);
    } finally {
      W.value = false;
    }
  }
  function ie(t) {
    g.value.splice(t, 1);
  }
  async function le() {
    let t = {}, n = [];
    if (d.value !== p.AUXILIARY_MATERIAL.V) {
      if (!await x.value.validate()) return;
      t = { id: s.detailInfo.id, pricingMannerEnum: e.value.pricingManner, pricingName: e.value.pricingName, pricingUnitTypeEnum: e.value.pricingUnitType, pricingWeightTypeEnum: e.value.pricingWeightType, productType: d.value, projectId: s.detailInfo.projectId, unitPrice: e.value.unitPrice }, n = g.value.map((i) => ({ id: i.id, productId: i.productId, quantity: i.quantity, unitPrice: e.value.unitPrice }));
    } else {
      const { validResult: a } = X(g.value);
      if (!a) return;
      t = { id: s.detailInfo.id, productType: d.value, projectId: s.detailInfo.projectId }, n = g.value.map((i) => ({ id: i.id, productId: i.productId, quantity: i.quantity, mete: i.mete, unitPrice: i.unitPrice }));
    }
    try {
      R.value = true, await Ae({ ...t, businessPriceDetailList: n }), ve.success("保存成功"), P(), L("success");
    } catch (a) {
      console.log(a);
    } finally {
      R.value = false;
    }
  }
  return (t, n) => {
    const a = Ee, i = E("common-button"), oe = be, f = Ie, k = E("common-select"), re = E("common-radio-button"), ue = Ve, se = Ue, H = we, ce = E("common-table"), pe = We, de = E("common-drawer"), me = Re;
    return m(), _(de, { ref_key: "drawerRef", ref: C, title: "清单计价编辑", modelValue: o(w), "onUpdate:modelValue": n[5] || (n[5] = (l) => Te(w) ? w.value = l : null), direction: "rtl", "before-close": o(P), size: "90%", "custom-class": "list-valuation-list-create-drawer" }, { titleAfter: u(() => {
      var l;
      return [r(a, { effect: "plain" }, { default: u(() => {
        var h;
        return [M("项目: " + A((h = T.detailInfo.project) == null ? void 0 : h.name), 1)];
      }), _: 1 }), d.value === o(p).STRUCTURE.V && ((l = T.detailInfo.project) != null && l.structureMeasureMode) ? (m(), _(a, { key: 0, effect: "plain", type: "warning" }, { default: u(() => {
        var h;
        return [M("项目结算方式：" + A(o(q).VL[(h = T.detailInfo.project) == null ? void 0 : h.structureMeasureMode]), 1)];
      }), _: 1 })) : V("", true)];
    }), titleRight: u(() => [r(i, { type: "success", loading: R.value, onClick: le }, { default: u(() => n[6] || (n[6] = [M("提交审核")])), _: 1, __: [6] }, 8, ["loading"])]), content: u(() => [d.value !== o(p).AUXILIARY_MATERIAL.V ? (m(), _(se, { key: 0, ref_key: "formRef", ref: x, class: "form-container", model: e.value, inline: "", rules: O }, { default: u(() => [r(f, { label: "计价名称", prop: "pricingName" }, { default: u(() => [r(oe, { modelValue: e.value.pricingName, "onUpdate:modelValue": n[0] || (n[0] = (l) => e.value.pricingName = l), placeholder: "请输入名称", clearable: "", style: { width: "267px" } }, null, 8, ["modelValue"])]), _: 1 }), r(f, { label: "计价方式", prop: "pricingManner" }, { default: u(() => [r(k, { modelValue: e.value.pricingManner, "onUpdate:modelValue": n[1] || (n[1] = (l) => e.value.pricingManner = l), type: "enum", options: Z.value, clearable: "", placeholder: "请选择计价方式", style: { width: "250px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), r(f, { label: "计价单位", prop: "pricingUnitType" }, { default: u(() => [r(k, { modelValue: e.value.pricingUnitType, "onUpdate:modelValue": n[2] || (n[2] = (l) => e.value.pricingUnitType = l), type: "enum", options: ee.value, clearable: "", placeholder: "请选择计价单位", noDataText: "请选择计价方式", style: { width: "250px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), n[7] || (n[7] = he("br", null, null, -1)), e.value.pricingManner === o(c).WEIGHT.V && d.value === o(p).STRUCTURE.V ? (m(), _(f, { key: 0, label: "计价重量类型", prop: "pricingWeightType" }, { default: u(() => [r(re, { modelValue: e.value.pricingWeightType, "onUpdate:modelValue": n[3] || (n[3] = (l) => e.value.pricingWeightType = l), default: "", type: "enum", options: o(b).ENUM, clearable: "", placeholder: "请选择计价重量类型" }, null, 8, ["modelValue", "options"])]), _: 1 })) : V("", true), r(f, { label: "单价", prop: "unitPrice" }, { default: u(() => [r(ue, { modelValue: e.value.unitPrice, "onUpdate:modelValue": n[4] || (n[4] = (l) => e.value.unitPrice = l), step: 1, min: 0, max: 9999999999, precision: 2, placeholder: "请填写单价", "controls-position": "right", style: { width: "180px" } }, null, 8, ["modelValue"])]), _: 1 }), r(f, { label: "金额", "label-width": "80px", class: "form-label-require" }, { default: u(() => [e.value.amount ? (m(), N("span", je, A(e.value.amount) + " 元", 1)) : (m(), N("span", Ge, "系统自动计算"))]), _: 1 }), r(f, { label: "", "label-width": "80px", class: "form-label-require" }, { default: u(() => {
      var l;
      return [d.value === o(p).STRUCTURE.V && ((l = T.detailInfo.project) == null ? void 0 : l.structureMeasureMode) === o(q).OVERWEIGHT.V && e.value.pricingManner === o(c).WEIGHT.V ? (m(), N("span", ze, " *当前项目为磅计结算，本页面展示为理论重量计算金额，仅供参考。实际货物价值请以发运清单为准。 ")) : V("", true)];
    }), _: 1 })]), _: 1, __: [7] }, 8, ["model"])) : V("", true), ye((m(), _(ce, { ref: "tableRef", data: g.value, "max-height": o(Q), showEmptySymbol: false, "show-summary": "", "summary-method": ae, "cell-class-name": o($), style: { width: "100%" } }, { default: u(() => [r(H, { label: "序号", type: "index", align: "center", width: "60" }), (m(), _(_e(te.value))), r(H, { label: "操作", align: "center", width: "80" }, { default: u(({ $index: l }) => [r(i, { disabled: g.value.length === 1, type: "danger", size: "small", icon: "el-icon-delete", onClick: (h) => ie(l) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[me, W.value]]), r(pe, { total: o(B), "current-page": o(I).pageNumber, "page-size": o(I).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(z), onCurrentChange: o(Y) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ke = Ne(Ye, [["__scopeId", "data-v-00cbd1cf"]]);
export {
  Ke as default
};
