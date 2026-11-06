import { ref as y } from "vue";
import { inject as oe } from "vue";
import { computed as A } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { createSlots as re } from "vue";
import { unref as e } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as V } from "vue";
import { toDisplayString as r } from "vue";
import { createElementVNode as m } from "vue";
import { createElementBlock as se } from "vue";
import { createCommentVNode as b } from "vue";
import { resolveDynamicComponent as ue } from "vue";
import { isRef as ce } from "vue";
import { ElMessageBox as N } from "element-plus";
import { ElMessage as de } from "element-plus";
import { ElDescriptionsItem as me } from "element-plus";
import { ElDescriptions as pe } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElTag as ge } from "element-plus";
import { ElPagination as ye } from "element-plus";
import { d as be, a as Ie } from "../../../../../../modules/list-valuation-9a754659.js";
import { u as he, J as Te, o as Ee, kQ as o, kD as f, G as Ae, jm as Ve, kO as we, p as D, kP as ve, ba as Re } from "../../../../../../shared/runtime.js";
import B from "../components/list-detail-table/structure.vue.js";
import Le from "../components/list-detail-table/enclosure.vue.js";
import xe from "../components/list-detail-table/auxiliary-material.vue.js";
const Se = { key: 0 }, Ne = { __name: "list-detail", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(t, { emit: z }) {
  const X = y([["auditTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]]]), w = oe("permission"), v = y(), R = z, g = t, Y = A(() => ({ id: g.detailInfo.id })), L = y([]), x = y(false), { visible: E, handleClose: S } = he({ emit: R, props: g, field: "visible", showHook: K }), { handleSizeChange: j, handleCurrentChange: H, total: F, setTotalPage: O, queryPage: h } = Te({ fetchHook: U }), { maxHeight: W } = Ee({ mainBox: ".list-valuation-list-detail-drawer", extraBox: [".el-drawer__header", ".descriptions-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => v.value.loaded), q = A(() => {
    switch (g.detailInfo.productType) {
      case o.STRUCTURE.V:
        return "unitListValuationStructureDetail";
      case o.ENCLOSURE.V:
        return "unitListValuationEnclosureDetail";
      case o.AUXILIARY_MATERIAL.V:
        return "unitListValuationAuxiliaryMaterialDetail";
      default:
        return "unitListValuationStructureDetail";
    }
  }), $ = A(() => {
    switch (g.detailInfo.productType) {
      case o.STRUCTURE.V:
        return B;
      case o.ENCLOSURE.V:
        return Le;
      case o.AUXILIARY_MATERIAL.V:
        return xe;
      default:
        return B;
    }
  }), G = y(false), J = y(false);
  async function K() {
    h.pageNumber = 1, await U();
  }
  async function U() {
    try {
      x.value = true;
      const { content: s = [], totalElements: i } = await be({ id: g.detailInfo.id, ...h });
      L.value = s, O(i);
    } catch (s) {
      console.log("获取详情", s);
    } finally {
      x.value = false;
    }
  }
  async function k(s) {
    try {
      s === f.PASS.V ? await N.confirm("是否确认通过审核？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }) : await N.confirm("是否确认驳回？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Ie({ auditStatus: s, id: g.detailInfo.id }), de.success(`${s === f.PASS.V ? "通过" : "驳回"}成功`), R("refresh"), S();
    } catch (i) {
      console.log(i);
    }
  }
  function Q(s) {
    return Re(s, { props: ["quantity", "pricingMete"] });
  }
  return (s, i) => {
    const Z = T("print-table"), C = T("common-button"), u = me, ee = pe, c = fe, te = ge, ae = T("common-table"), ne = ye, ie = T("common-drawer"), le = P("permission"), _ = P("thousand");
    return d(), p(ie, { ref_key: "drawerRef", ref: v, title: "清单计价详情", modelValue: e(E), "onUpdate:modelValue": i[2] || (i[2] = (l) => ce(E) ? E.value = l : null), direction: "rtl", "before-close": e(S), size: "85%", "custom-class": "list-valuation-list-detail-drawer" }, re({ titleAfter: a(() => [V(n(Z, { "api-key": q.value, params: Y.value, type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[le, e(w).print]])]), content: a(() => [n(ee, { class: "descriptions-container", border: "", column: t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? 4 : 2, "label-width": "100px", style: { "margin-bottom": "10px" } }, { default: a(() => [n(u, { "label-align": "center", label: "项目", span: t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? 1 : 2 }, { default: a(() => {
      var l, M;
      return [I(r((l = t.detailInfo.project) == null ? void 0 : l.serialNumber) + " " + r((M = t.detailInfo.project) == null ? void 0 : M.shortName), 1)];
    }), _: 1 }, 8, ["span"]), t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? (d(), p(u, { key: 0, "label-align": "center", label: "计价方式" }, { default: a(() => [m("span", null, r(e(Ve).VL[t.detailInfo.pricingMannerEnum]), 1), t.detailInfo.productType === e(o).STRUCTURE.V && t.detailInfo.pricingWeightTypeEnum ? (d(), se("span", Se, "【" + r(e(we).VL[t.detailInfo.pricingWeightTypeEnum]) + "】", 1)) : b("", true)]), _: 1 })) : b("", true), t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? (d(), p(u, { key: 1, "label-align": "center", label: "总量" }, { default: a(() => [m("span", null, r(t.detailInfo.pricingMete), 1)]), _: 1 })) : b("", true), n(u, { "label-align": "center", label: "金额（元）", span: t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? 1 : 2 }, { default: a(() => [V(m("span", null, null, 512), [[_, { val: t.detailInfo.totalPrice || 0 }]])]), _: 1 }, 8, ["span"]), n(u, { "label-align": "center", label: "创建人" }, { default: a(() => [I(r(t.detailInfo.createUserName), 1)]), _: 1 }), n(u, { "label-align": "center", label: "创建日期" }, { default: a(() => [m("span", null, r(e(D)(t.detailInfo.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), t.detailInfo.auditUserName ? (d(), p(u, { key: 2, "label-align": "center", label: "审核人" }, { default: a(() => [m("span", null, r(t.detailInfo.auditUserName), 1)]), _: 1 })) : b("", true), t.detailInfo.auditTime ? (d(), p(u, { key: 3, "label-align": "center", label: "审核日期" }, { default: a(() => [m("span", null, r(e(D)(t.detailInfo.auditTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 })) : b("", true)]), _: 1 }, 8, ["column"]), n(ae, { data: L.value, "max-height": e(W), "show-summary": "", "summary-method": Q, "data-format": X.value, style: { width: "100%" } }, { default: a(() => [n(c, { label: "序号", type: "index", align: "center", width: "60" }), (d(), p(ue($.value))), t.detailInfo.productType !== e(o).AUXILIARY_MATERIAL.V ? (d(), p(c, { key: 0, prop: "pricingUnitTypeEnum", align: "center", width: "90", label: "计价单位" }, { default: a(({ row: l }) => [m("span", null, r(e(ve).VL[l.pricingUnitTypeEnum]), 1)]), _: 1 })) : b("", true), n(c, { prop: "pricingMete", align: "center", "min-width": "120", label: "核算量" }), n(c, { prop: "unitPrice", align: "right", "min-width": "120", label: "单价（元）" }), n(c, { prop: "totalPrice", align: "right", "min-width": "120", label: "金额（元）" }, { default: a(({ row: l }) => [V(m("span", null, null, 512), [[_, { val: l.totalPrice || 0 }]])]), _: 1 }), n(c, { label: "状态", width: "100px", align: "center", fixed: "right", prop: "auditStatus" }, { default: a(({ row: l }) => [n(te, { type: e(f).V[l.auditStatus].TAG }, { default: a(() => [I(r(e(f).VL[l.auditStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), n(c, { label: "审核人", width: "100", fixed: "right", align: "center", prop: "auditUserName" }), n(c, { label: "审核日期", width: "150", fixed: "right", align: "center", prop: "auditTime" })]), _: 1 }, 8, ["data", "max-height", "data-format"]), n(ne, { total: e(F), "current-page": e(h).pageNumber, "page-size": e(h).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(j), onCurrentChange: e(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 2 }, [t.detailInfo.auditStatus === e(f).UNREVIEWED.V && e(Ae)(e(w).audit) ? { name: "titleRight", fn: a(() => [n(C, { type: "success", loading: G.value, onClick: i[0] || (i[0] = (l) => k(e(f).PASS.V)) }, { default: a(() => i[3] || (i[3] = [I("审核通过")])), _: 1, __: [3] }, 8, ["loading"]), n(C, { type: "danger", loading: J.value, onClick: i[1] || (i[1] = (l) => k(e(f).REFUSE.V)) }, { default: a(() => i[4] || (i[4] = [I("驳回")])), _: 1, __: [4] }, 8, ["loading"])]), key: "0" } : void 0]), 1032, ["modelValue", "before-close"]);
  };
} };
export {
  Ne as default
};
