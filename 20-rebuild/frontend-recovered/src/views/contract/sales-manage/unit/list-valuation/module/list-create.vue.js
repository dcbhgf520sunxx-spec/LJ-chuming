import { ref as m } from "vue";
import { provide as me } from "vue";
import { computed as b } from "vue";
import { watch as ge } from "vue";
import { watchEffect as ye } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as g } from "vue";
import { createBlock as h } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as M } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as I } from "vue";
import { createElementVNode as S } from "vue";
import { withDirectives as H } from "vue";
import { vShow as j } from "vue";
import { createElementBlock as W } from "vue";
import { resolveDynamicComponent as fe } from "vue";
import { isRef as Te } from "vue";
import { ElMessageBox as ve } from "element-plus";
import { ElMessage as he } from "element-plus";
import { ElTag as Ee } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElFormItem as be } from "element-plus";
import { ElInputNumber as Ve } from "element-plus";
import { ElForm as Ie } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { h as Ue, i as we } from "../../../../../../modules/list-valuation-9a754659.js";
import { _ as Re, n as Ae, kO as E, u as Me, jm as c, kQ as p, kP as N, o as We, iz as D, aw as Le, ba as Ce, i as xe } from "../../../../../../shared/runtime.js";
import G from "../components/list-create-table/structure.vue.js";
import qe from "../components/list-create-table/enclosure.vue.js";
import Pe from "../components/list-create-table/auxiliary-material.vue.js";
const ke = { class: "flex-rsc", style: { width: "450px" } }, Se = { key: 0, style: { color: "#999" } }, He = { key: 1 }, je = { key: 0, style: { "font-size": "13px", color: "#e6a23c" } }, De = { __name: "list-create", props: { visible: { type: Boolean, default: false }, addList: { type: Array, default: () => [] }, query: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "clear-all", "clear", "success"], setup(d, { emit: B }) {
  const y = { CREATE: { L: "类型命名", K: "CREATE", V: 1 }, ADD: { L: "加入已创建", K: "ADD", V: 2 } };
  Ae(y);
  const L = m(), C = m(), _ = B, u = d, Y = m(), U = m(false), x = m([]), T = m({}), q = m(false), e = m({ createType: y.CREATE.V, pricingName: void 0, pricingManner: void 0, pricingUnitType: void 0, pricingWeightType: void 0, unitPrice: void 0 }), O = { pricingName: [{ required: true, message: "请输入名称", trigger: "change" }], pricingNameId: [{ required: true, message: "请选择已创建的名称", trigger: "change" }], pricingManner: [{ required: true, message: "请选择计价方式", trigger: "change" }], pricingUnitType: [{ required: true, message: "请选择计价单位", trigger: "change" }], pricingWeightType: [{ required: true, message: "请选择计价重量类型", trigger: "change" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }] }, Q = { unitPrice: [{ validator: (a, t) => xe(a), message: "请填写单价", trigger: ["blur", "change"] }] }, { tableValidate: z, wrongCellMask: F } = Le({ rules: Q });
  me("weightType", b(() => e.value.pricingWeightType || E.NET_WEIGHT.V));
  const { visible: w, handleClose: R } = Me({ emit: _, props: u, field: "visible", showHook: ae }), K = { [c.WEIGHT.V]: "totalWeight", [c.QUANTITY.V]: "totalQuantity", [c.AREA.V]: "totalArea", [c.LENGTH.V]: "totalLength" }, X = { [E.NET_WEIGHT.V]: "totalNetWeight", [E.GROSS_WEIGHT.V]: "totalGrossWeight", [E.DRAW_WEIGHT.V]: "drawingTotalWeight" };
  ge(() => e.value.createType, () => {
    e.value.pricingNameId = void 0, e.value.pricingManner = void 0, e.value.pricingUnitType = void 0, e.value.pricingWeightType = void 0, e.value.unitPrice = void 0;
  }), ye(() => {
    const a = u.addList.reduce((n, i) => (i.productType === p.STRUCTURE.V ? n.totalWeight += +e.value.pricingWeightType ? i[X[e.value.pricingWeightType]] : i.totalNetWeight : i.productType === p.ENCLOSURE.V && (n.totalWeight += +i.enclosureTotalWeight || 0, n.totalLength += +i.totalLength, n.totalArea += +i.totalArea), n.totalQuantity += +i.quantity, n), { totalWeight: 0, totalArea: 0, totalQuantity: 0, totalLength: 0 });
    let t = e.value.unitPrice;
    e.value.pricingUnitType === N.DUN.V && (t = t / 1e3), t && e.value.pricingManner && e.value.pricingUnitType ? e.value.amount = (t * a[K[e.value.pricingManner]]).toFixed(2) : e.value.amount = void 0;
  });
  const $ = b(() => {
    const a = [];
    return u.query.productType === p.STRUCTURE.V && (a.push(c.WEIGHT), a.push(c.QUANTITY), a.push(c.LENGTH)), u.query.productType === p.ENCLOSURE.V && (a.push(c.WEIGHT), a.push(c.LENGTH), a.push(c.AREA), a.push(c.QUANTITY)), u.query.productType === p.AUXILIARY_MATERIAL.V && a.push(c.QUANTITY), a;
  }), J = b(() => {
    const a = [];
    return N.KEYS.forEach((n) => {
      N[n].pm === e.value.pricingManner && a.push(N[n]);
    }), a;
  }), Z = b(() => {
    switch (u.query.productType) {
      case p.STRUCTURE.V:
        return G;
      case p.ENCLOSURE.V:
        return qe;
      case p.AUXILIARY_MATERIAL.V:
        return Pe;
      default:
        return G;
    }
  }), { maxHeight: ee } = We({ mainBox: ".list-valuation-list-create-drawer", extraBox: [".el-drawer__header", ".form-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => C.value.loaded);
  function te(a) {
    return Ce(a, { props: ["quantity", "totalNetWeight", "totalGrossWeight", "drawingTotalWeight", "totalLength", "totalArea", "totalPrice", "enclosureTotalWeight"] });
  }
  function ae() {
    e.value = {}, ne();
  }
  async function ne() {
    try {
      T.value = {}, q.value = true;
      const { content: a } = await Ue({ projectId: u.query.projectId, productType: u.query.productType });
      x.value = a || [], T.value = a.reduce((t, n) => (t[n.id] = n, t), {});
    } catch (a) {
      console.log(a);
    } finally {
      q.value = false;
    }
  }
  function ie() {
    var a;
    (a = e.value) != null && a.pricingNameId && (e.value.pricingManner = T.value[e.value.pricingNameId].pricingMannerEnum, e.value.pricingUnitType = T.value[e.value.pricingNameId].pricingUnitTypeEnum, e.value.pricingWeightType = T.value[e.value.pricingNameId].pricingWeightTypeEnum, e.value.unitPrice = T.value[e.value.pricingNameId].unitPrice);
  }
  async function le() {
    try {
      await ve.confirm("是否确认清空当前清单计价创建列表？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), _("clear-all"), R();
    } catch (a) {
      console.log(a);
    }
  }
  function re(a) {
    _("clear", a);
  }
  async function oe() {
    let a = {}, t = [];
    if (u.query.productType !== p.AUXILIARY_MATERIAL.V) {
      if (!await L.value.validate()) return;
      a = { boolAddEnum: e.value.createType === y.ADD.V, id: e.value.pricingNameId, pricingMannerEnum: e.value.pricingManner, pricingName: e.value.pricingName, pricingUnitTypeEnum: e.value.pricingUnitType, pricingWeightTypeEnum: e.value.pricingWeightType, productType: u.query.productType, projectId: u.query.projectId, unitPrice: e.value.unitPrice }, t = u.addList.map((i) => ({ productId: i.productId, quantity: i.quantity, unitPrice: e.value.unitPrice }));
    } else {
      const { validResult: n } = z(u.addList);
      if (!n) return;
      a = { productType: u.query.productType, projectId: u.query.projectId }, t = u.addList.map((i) => ({ productId: i.productId, quantity: i.quantity, mete: i.mete, unitPrice: i.unitPrice }));
    }
    try {
      U.value = true, await we({ ...a, businessPriceDetailList: t }), he.success("创建成功"), R(), _("success");
    } catch (n) {
      console.log(n);
    } finally {
      U.value = false;
    }
  }
  return (a, t) => {
    const n = Ee, i = v("common-button"), P = v("common-radio-button"), ue = _e, A = v("common-select"), f = be, ce = Ve, se = Ie, k = Ne, pe = v("common-table"), de = v("common-drawer");
    return g(), h(de, { ref_key: "drawerRef", ref: C, title: "清单计价创建", modelValue: s(w), "onUpdate:modelValue": t[7] || (t[7] = (r) => Te(w) ? w.value = r : null), direction: "rtl", "before-close": s(R), size: "90%", "custom-class": "list-valuation-list-create-drawer" }, { titleAfter: o(() => [l(n, { effect: "plain" }, { default: o(() => [V("项目：" + M(d.projectInfo.name), 1)]), _: 1 }), d.query.productType === s(p).STRUCTURE.V && d.projectInfo.structureMeasureMode ? (g(), h(n, { key: 0, effect: "plain", type: "warning" }, { default: o(() => [V("项目结算方式：" + M(s(D).VL[d.projectInfo.structureMeasureMode]), 1)]), _: 1 })) : I("", true)]), titleRight: o(() => [l(i, { type: "success", loading: U.value, onClick: oe }, { default: o(() => t[8] || (t[8] = [V("提交审核")])), _: 1, __: [8] }, 8, ["loading"]), l(i, { type: "danger", onClick: le }, { default: o(() => t[9] || (t[9] = [V("清空")])), _: 1, __: [9] })]), content: o(() => [d.query.productType !== s(p).AUXILIARY_MATERIAL.V ? (g(), h(se, { key: 0, ref_key: "formRef", ref: L, class: "form-container", model: e.value, inline: "", rules: O }, { default: o(() => [l(f, { label: "计价名称", prop: e.value.createType === y.CREATE.V ? "pricingName" : "pricingNameId" }, { default: o(() => [S("div", ke, [l(P, { modelValue: e.value.createType, "onUpdate:modelValue": t[0] || (t[0] = (r) => e.value.createType = r), default: "", options: y.ENUM, type: "enum", size: "default", style: { "margin-right": "10px" } }, null, 8, ["modelValue", "options"]), H(l(ue, { modelValue: e.value.pricingName, "onUpdate:modelValue": t[1] || (t[1] = (r) => e.value.pricingName = r), placeholder: "请输入名称", clearable: "", style: { width: "267px" } }, null, 8, ["modelValue"]), [[j, e.value.createType === y.CREATE.V]]), H(l(A, { modelValue: e.value.pricingNameId, "onUpdate:modelValue": t[2] || (t[2] = (r) => e.value.pricingNameId = r), options: x.value, type: "other", dataStructure: { key: "id", label: "pricingName", value: "id" }, clearable: "", filterable: "", placeholder: "请选择已创建的名称", style: { width: "267px" }, onChange: ie }, null, 8, ["modelValue", "options"]), [[j, e.value.createType === y.ADD.V]])])]), _: 1 }, 8, ["prop"]), l(f, { label: "计价方式", prop: "pricingManner" }, { default: o(() => [l(A, { modelValue: e.value.pricingManner, "onUpdate:modelValue": t[3] || (t[3] = (r) => e.value.pricingManner = r), type: "enum", disabled: !!e.value.pricingNameId, options: $.value, clearable: "", placeholder: "请选择计价方式", style: { width: "250px" } }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), l(f, { label: "计价单位", prop: "pricingUnitType" }, { default: o(() => [l(A, { modelValue: e.value.pricingUnitType, "onUpdate:modelValue": t[4] || (t[4] = (r) => e.value.pricingUnitType = r), type: "enum", options: J.value, disabled: !!e.value.pricingNameId, clearable: "", placeholder: "请选择计价单位", noDataText: "请选择计价方式", style: { width: "250px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), t[10] || (t[10] = S("br", null, null, -1)), e.value.pricingManner === s(c).WEIGHT.V && d.query.productType === s(p).STRUCTURE.V ? (g(), h(f, { key: 0, label: "计价重量类型", prop: "pricingWeightType" }, { default: o(() => [l(P, { modelValue: e.value.pricingWeightType, "onUpdate:modelValue": t[5] || (t[5] = (r) => e.value.pricingWeightType = r), default: "", type: "enum", disabled: !!e.value.pricingNameId, options: s(E).ENUM, clearable: "", placeholder: "请选择计价重量类型" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })) : I("", true), l(f, { label: "单价", prop: "unitPrice" }, { default: o(() => [l(ce, { modelValue: e.value.unitPrice, "onUpdate:modelValue": t[6] || (t[6] = (r) => e.value.unitPrice = r), step: 1, min: 0, max: 9999999999, disabled: !!e.value.pricingNameId, precision: 2, placeholder: "请填写单价", "controls-position": "right", style: { width: "180px" } }, null, 8, ["modelValue", "disabled"])]), _: 1 }), l(f, { label: "金额", "label-width": "80px", class: "form-label-require" }, { default: o(() => [e.value.amount ? (g(), W("span", He, M(e.value.amount) + " 元", 1)) : (g(), W("span", Se, "系统自动计算"))]), _: 1 }), l(f, { label: "", "label-width": "80px", class: "form-label-require" }, { default: o(() => [d.query.productType === s(p).STRUCTURE.V && d.projectInfo.structureMeasureMode === s(D).OVERWEIGHT.V && e.value.pricingManner === s(c).WEIGHT.V ? (g(), W("span", je, " *当前项目为磅计结算，本页面展示为理论重量计算金额，仅供参考。实际货物价值请以发运清单为准。 ")) : I("", true)]), _: 1 })]), _: 1, __: [10] }, 8, ["model"])) : I("", true), l(pe, { ref_key: "tableRef", ref: Y, data: d.addList, "max-height": s(ee), showEmptySymbol: false, "show-summary": "", "summary-method": te, "cell-class-name": s(F), style: { width: "100%" } }, { default: o(() => [l(k, { label: "序号", type: "index", align: "center", width: "60" }), (g(), h(fe(Z.value))), l(k, { label: "操作", align: "center", width: "80" }, { default: o(({ $index: r }) => [l(i, { type: "danger", size: "small", icon: "el-icon-delete", onClick: (Be) => re(r) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Xe = Re(De, [["__scopeId", "data-v-23160653"]]);
export {
  Xe as default
};
