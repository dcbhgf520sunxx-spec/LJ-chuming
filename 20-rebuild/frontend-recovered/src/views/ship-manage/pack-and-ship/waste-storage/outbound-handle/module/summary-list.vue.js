import { inject as O } from "vue";
import { ref as b } from "vue";
import { reactive as ve } from "vue";
import { computed as f } from "vue";
import { watch as _e } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { unref as p } from "vue";
import { createTextVNode as Ve } from "vue";
import { createCommentVNode as d } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as _ } from "vue";
import { createElementBlock as we } from "vue";
import { withDirectives as Ae } from "vue";
import { toDisplayString as M } from "vue";
import { isRef as Ee } from "vue";
import { ElMessageBox as ke } from "element-plus";
import { ElMessage as Me } from "element-plus";
import { nextTick as Te } from "vue";
import { ElFormItem as xe } from "element-plus";
import { ElInput as Ie } from "element-plus";
import { ElForm as Le } from "element-plus";
import { ElTableColumn as Ue } from "element-plus";
import { ElInputNumber as Ce } from "element-plus";
import { vLoading as Re } from "element-plus";
import { g as Pe } from "../../../../../../modules/scrap-sell-e306ced6.js";
import { l as F, _ as Se, fg as je, o as qe, V as Ne, kH as I, kI as L, kG as m, kC as z, u as He, G as De, ur as U, fD as Be, bV as V, aw as We, ba as Oe } from "../../../../../../shared/runtime.js";
function ze(w) {
  return F({ url: "/api/project/returnProductChild/getReturnAndWaste", method: "get", params: w });
}
function Fe(w) {
  return F({ url: "/api/project/wasteProductMain/save", method: "post", data: w });
}
const Ze = { get: ze };
const Ge = { class: "form-row" }, $e = { key: 0, class: "form-row" }, Ye = { __name: "summary-list", props: { visible: { type: Boolean, default: false }, auditDataList: { type: Array, default: () => [] } }, emits: ["update:visible", "delete", "success"], setup(w, { expose: G, emit: $ }) {
  const { projectTree: Y } = je(), X = O("permission"), C = $, R = w, s = O("query"), Q = b(false), P = b(false), q = b([]), N = b([]), h = b(), u = ve({ wasteHandleMethod: void 0, useProjectId: void 0 }), T = b(), v = b(), { maxHeight: J } = qe({ paginate: false }), K = f(() => y.value || te.value ? 8 : A.value || ee.value ? 1 : 0), Z = f(() => {
    var e;
    return (e = Y.value) == null ? void 0 : e.filter((t) => t.projectType === K.value && t.id !== s.projectId);
  });
  _e(() => R.auditDataList, (e) => {
    const t = Ne(R.auditDataList);
    v.value = t.map((c) => (c.originQuantity = c.quantity, c.originUnitPrice = c.unitPrice, (g.value || y.value) && (g.value && (c.pricingManner = I.WEIGHT.V), y.value && (c.pricingManner = L.LENGTH.V)), c));
  }, { immediate: true, deep: true });
  const g = f(() => s.type === m.AUXILIARY_MATERIAL.V), y = f(() => s.type === m.ENCLOSURE.V), A = f(() => s.type === m.STRUCTURE.V), ee = f(() => s.type === m.AUXILIARY_MATERIAL.V && s.relationType === z.STRUCTURE.V), te = f(() => s.type === m.AUXILIARY_MATERIAL.V && s.relationType === z.ENCLOSURE.V), { visible: S, handleClose: H } = He({ emit: C, props: R, field: "visible" }), ae = { quantity: [{ required: true, message: "请选择输入数量", trigger: "blur" }] }, { tableValidate: le, cleanUpData: oe, wrongCellMask: ne } = We({ rules: ae, errorMsg: "请修正表格中标红的信息" }), re = { wasteHandleMethod: [{ required: true, message: "请选择处理方式", trigger: "change" }], useProjectId: [{ required: true, message: "请选择二次利用项目", trigger: "change" }], totalAmount: [{ required: true, message: "请输入金额", trigger: "blur" }] }, ie = f(() => s.type === m.STRUCTURE.V ? I : s.type === m.ENCLOSURE.V ? L : {});
  function se(e, t) {
    s.type === m.STRUCTURE.V && (e.pricingManner === I.WEIGHT.V && (e.totalAmount = e.unitPrice * e.quantity * e.netWeight || "-", V(e.totalAmount, 3), console.log("结构-重量", e.totalAmount)), e.pricingManner === I.LENGTH.V && (e.totalAmount = e.unitPrice * e.quantity * e.length || "-", V(e.totalAmount, 3), console.log("结构-长度", e.totalAmount))), s.type === m.ENCLOSURE.V && (e.pricingManner === L.AREA.V && (e.totalAmount = e.unitPrice * e.quantity * e.surfaceArea || "-", V(e.totalAmount, 3), console.log("围护-面积", e.totalAmount)), e.pricingManner === L.LENGTH.V && (e.totalAmount = e.unitPrice * e.quantity * e.length || "-", V(e.totalAmount, 3), console.log("围护-长度", e.totalAmount))), s.type === m.AUXILIARY_MATERIAL.V && (e.mete = (e.singleMete * e.quantity).toFixed(2) || "-", e.totalAmount = e.unitPrice * e.quantity * e.singleMete || "-", V(e.totalAmount, 3), console.log("配套件制品", e.totalAmount));
  }
  function ue(e) {
    return Oe(e, { props: ["quantity", ["totalAmount", 3]], toThousandFields: ["totalAmount"] });
  }
  function ce(e) {
    C("delete", e);
  }
  de();
  async function de() {
    try {
      const { content: e } = await Pe();
      N.value = e, q.value = e.map((t) => {
        const c = {};
        return c.id = t.id, c.name = t.purchaser, c;
      });
    } catch (e) {
      console.log("获取购买单位失败", e);
    }
  }
  function pe(e) {
    N.value.forEach((t) => {
      t.id === e && (u.contractNumber = t.serialNumber);
    });
  }
  async function me() {
    if (!await h.value.validate()) return false;
    const { validResult: t } = le(v.value);
    if (t && oe(v.value), !t) return false;
    const c = { ...u, projectWasteProductChildVOList: v.value, remark: T.value, projectId: s.projectId, productType: s.type, relationType: s.relationType };
    ke.confirm("选择报废或二次利用之后，保存不能回退，请确认!", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      P.value = true, await Fe(c), Me.success("提交成功"), C("success"), D(), H();
    }).catch((E) => {
      console.log(E);
    }).finally(() => {
      P.value = false;
    });
  }
  function D() {
    Te(() => {
      h.value && h.value.resetFields(), h.value && h.value.clearValidate(), T.value = void 0, v.value = [];
    });
  }
  return G({ resetForm: D }), (e, t) => {
    const c = x("common-button"), E = x("common-select"), k = xe, B = Ie, fe = Le, l = Ue, ge = Ce, ye = x("common-table"), be = x("common-drawer"), he = Re;
    return n(), i(be, { "append-to-body": "", ref: "drawerRef", title: "制成品出库办理", modelValue: p(S), "onUpdate:modelValue": t[6] || (t[6] = (a) => Ee(S) ? S.value = a : null), direction: "rtl", "before-close": p(H), size: "80%" }, { titleAfter: r(() => t[7] || (t[7] = [])), titleRight: r(() => [p(De)(p(X).submit) ? (n(), i(c, { key: 0, loading: P.value, type: "success", size: "default", onClick: me }, { default: r(() => t[8] || (t[8] = [Ve(" 保存 ")])), _: 1, __: [8] }, 8, ["loading"])) : d("", true)]), content: r(() => [o(fe, { class: "form", ref_key: "formRef", ref: h, model: u, rules: re }, { default: r(() => [_("div", Ge, [o(k, { class: "form-item", label: "处理方式", prop: "wasteHandleMethod" }, { default: r(() => [o(E, { modelValue: u.wasteHandleMethod, "onUpdate:modelValue": t[0] || (t[0] = (a) => u.wasteHandleMethod = a), options: p(U).ENUM, type: "enum", size: "default", style: { width: "100%", height: "100%" }, placeholder: "请选择处理方式", class: "input-border-none" }, null, 8, ["modelValue", "options"])]), _: 1 }), u.wasteHandleMethod === p(U).SELL.V ? (n(), i(k, { key: 0, class: "form-item input", label: "金额（元）", prop: "freight" }, { default: r(() => [o(B, { modelValue: u.totalAmount, "onUpdate:modelValue": t[1] || (t[1] = (a) => u.totalAmount = a), modelModifiers: { number: true }, type: "number", placeholder: "输入金额", style: { width: "100%", height: "100%" }, class: "input-border-none", size: "small", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })) : d("", true), u.wasteHandleMethod === p(U).RECYCLE.V ? (n(), i(k, { key: 1, class: "form-item", label: "二次利用项目", prop: "useProjectId" }, { default: r(() => [o(E, { modelValue: u.useProjectId, "onUpdate:modelValue": t[2] || (t[2] = (a) => u.useProjectId = a), options: Z.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", class: "input-border-none", filterable: "", style: { width: "100%", height: "100%" }, placeholder: "选择项目" }, null, 8, ["modelValue", "options"])]), _: 1 })) : d("", true)]), u.wasteHandleMethod === p(U).SELL.V ? (n(), we("div", $e, [o(k, { class: "form-item", label: "购买方", prop: "contractWasteId" }, { default: r(() => [o(E, { class: "input-border-none", style: { width: "100%" }, placeholder: "请选择购买方", modelValue: u.contractWasteId, "onUpdate:modelValue": t[3] || (t[3] = (a) => u.contractWasteId = a), filterable: "", options: q.value, onChange: pe }, null, 8, ["modelValue", "options"])]), _: 1 }), o(k, { class: "form-item", label: "出售方", prop: "branchCompanyId" }, { default: r(() => [o(Be, { modelValue: u.branchCompanyId, "onUpdate:modelValue": t[4] || (t[4] = (a) => u.branchCompanyId = a), class: "input-border-none", clearable: "", filterable: "", placeholder: "请选择出售方", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })])) : d("", true)]), _: 1 }, 8, ["model"]), Ae((n(), i(ye, { ref: "tableRef", data: v.value, "return-source-data": "", "cell-class-name": p(ne), "max-height": p(J), "show-summary": "", "summary-method": ue, style: { width: "100%", margin: "15px 0px" } }, { default: r(() => [o(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), o(l, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), g.value ? d("", true) : (n(), i(l, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" })), y.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" }, { default: r((a) => [_("span", null, M(a.row.plate || "-"), 1)]), _: 1 })) : d("", true), o(l, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }), A.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center" })) : d("", true), g.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "singleMete", key: "singleMete", label: "单核算量", align: "center" })) : d("", true), g.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : d("", true), g.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : d("", true), A.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : d("", true), A.value || y.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "pricingManner", key: "pricingManner", label: "计价方式", align: "center", width: "120px" }, { default: r((a) => [_("span", null, M(ie.value.VL[a.row.pricingManner] || "-"), 1)]), _: 1 })) : d("", true), o(l, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center", width: "120px" }, { default: r((a) => {
      var j;
      return [o(ge, { modelValue: a.row.quantity, "onUpdate:modelValue": (W) => a.row.quantity = W, "controls-position": "right", step: 1, max: (j = a.row) == null ? void 0 : j.originQuantity, min: 1, precision: 0, onChange: (W) => se(a.row, a.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])];
    }), _: 1 }), g.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : d("", true), A.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : d("", true), y.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长（m）", align: "center" })) : d("", true), y.value ? (n(), i(l, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center", width: "100px" }, { default: r((a) => [_("span", null, M(a.row.surfaceArea || "-"), 1)]), _: 1 })) : d("", true), o(l, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价（元）", align: "center", width: "150px" }, { default: r((a) => [_("span", null, M(a.row.unitPrice), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价（元）", align: "center" }, { default: r((a) => [_("span", null, M(p(V)(a.row.totalAmount, 3) || 0), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", label: "操作", align: "center", fixed: "right" }, { default: r((a) => [o(c, { type: "danger", size: "default", icon: "el-icon-delete", onClick: (j) => ce(a.$index), disabled: !a.row.id }, null, 8, ["onClick", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[he, Q.value]]), o(B, { class: "remark", type: "textarea", placeholder: "备注说明", maxlength: "200", "show-word-limit": "", modelValue: T.value, "onUpdate:modelValue": t[5] || (t[5] = (a) => T.value = a) }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Xe = Se(Ye, [["__scopeId", "data-v-e977dbe6"]]), et = Object.freeze(Object.defineProperty({ __proto__: null, default: Xe }, Symbol.toStringTag, { value: "Module" }));
export {
  et as a,
  Ze as c,
  Xe as s
};
