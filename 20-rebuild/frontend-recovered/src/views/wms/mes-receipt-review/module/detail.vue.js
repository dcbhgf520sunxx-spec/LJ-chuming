import { ref as r } from "vue";
import { inject as Y } from "vue";
import { computed as E } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as u } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as _ } from "vue";
import { withDirectives as N } from "vue";
import { createVNode as e } from "vue";
import { vShow as ee } from "vue";
import { createElementVNode as b } from "vue";
import { isRef as te } from "vue";
import { ElTag as ae } from "element-plus";
import { ElDescriptionsItem as ie } from "element-plus";
import { ElDescriptions as oe } from "element-plus";
import { ElDivider as le } from "element-plus";
import { ElTableColumn as ne } from "element-plus";
import { vLoading as se } from "element-plus";
import { r as re } from "../../../../modules/mes-receipt-review-377f871a.js";
import { _ as ce, jX as me, o as ue, u as pe, c as de, jN as V, i as j, Bj as C, z as fe, am as O, ba as we } from "../../../../shared/runtime.js";
import ge from "./print-table/index.vue.js";
import _e from "./handle-detail-table.vue.js";
import "./outbound-detail.vue.js";
const ye = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) }, showType: { type: String, default: "detail" } }, emits: ["refresh", "update:modelValue"], setup(n, { emit: R }) {
  const P = R, h = n, B = r(), f = r(false), k = r([]), v = r([]), H = r(false), A = r([]), I = r({}), x = r(false), T = Y("mainCurrentRow"), U = r([...me, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), q = E(() => "明细"), { maxHeight: D } = ue({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => E(() => !f.value)), { visible: w, handleClose: S } = pe({ emit: P, props: h, closeHook: F });
  Z(w, async (m) => {
    m && await z();
  }, { immediate: true });
  async function z() {
    var i;
    const m = h.data.id;
    if (m) try {
      f.value = true;
      const c = JSON.parse(JSON.stringify(await re(m)));
      (i = c.wmsPickingDetailDTOList) == null || i.forEach((o) => {
        o.pickingAmount = de(o.pickingAmount, "kg", V.weight.unit, V.weight.precision), o.unit = V.weight.unit, o.accountingUnit = V.weight.unit, o.accountingPrecision = V.weight.precision, o.volume = de(o.volume, "g", V.weight.unit, V.weight.precision), o.wmsPickingDetailDTOList && o.wmsPickingDetailDTOList.forEach((p) => {
          p.pickingAmount = de(p.pickingAmount, "kg", V.weight.unit, V.weight.precision), p.unit = V.weight.unit, p.accountingUnit = V.weight.unit, p.accountingPrecision = V.weight.precision, p.volume = de(p.volume, "g", V.weight.unit, V.weight.precision);
        }), o.pickingList = j(o.wmsPickingDetailDTOList) ? o.wmsPickingDetailDTOList : [{ ...o }];
      }), k.value = JSON.parse(JSON.stringify(c.wmsPickingDetailDTOList)), v.value = JSON.parse(JSON.stringify(c.wmsPickingDetailDTOList)), I.value = c;
    } catch (c) {
      console.log("加载失败", c);
    } finally {
      f.value = false;
    }
  }
  function J() {
    x.value = false, S();
  }
  function F() {
  }
  function M(m) {
    return we(m, { props: ["quantity", ["pickingAmount", V.weight.precision]] });
  }
  return (m, i) => {
    const c = ae, o = ie, K = oe, L = le, X = y("table-cell-tag"), s = ne, $ = y("common-table"), G = y("common-drawer"), Q = se;
    return u(), p(G, { ref_key: "drawerRef", ref: B, modelValue: t(w), "onUpdate:modelValue": i[0] || (i[0] = (l) => te(w) ? w.value = l : null), "content-loading": f.value, "before-close": t(S), title: q.value, "show-close": true, "close-on-click-modal": false, size: "80%", "custom-class": "raw-mat-application-review-form" }, { titleAfter: a(() => {
      var l;
      return [n.data.transactStatus ? (u(), p(c, { key: 0, type: (l = t(C).V[n.data.transactStatus]) == null ? void 0 : l.T, size: "default" }, { default: a(() => [g(d(t(C).VL[n.data.transactStatus]), 1)]), _: 1 }, 8, ["type"])) : _("", true), N(e(t(ge), { "api-key": "wmsRmMesOutboundReceipt", params: [n.data.id], size: "default", type: "warning", class: "filter-item", isPrint: x.value, onSuccess: J }, null, 8, ["params", "isPrint"]), [[ee, false]])];
    }), titleRight: a(() => i[1] || (i[1] = [])), content: a(() => [e(K, { column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: a(() => [e(o, { label: "项目", "label-class-name": "contractLabel" }, { default: a(() => [g(d(t(j)(n.data.project) ? t(fe)(n.data.project) : "-"), 1)]), _: 1 }), e(o, { label: "工单号", "label-class-name": "contractLabel" }, { default: a(() => [g(d(n.data.taskOrderNumber || "-"), 1)]), _: 1 }), e(o, { label: "申领人", "label-class-name": "contractLabel" }, { default: a(() => {
      var l;
      return [g(d(((l = n.data.applicant) == null ? void 0 : l.name) || "-"), 1)];
    }), _: 1 })]), _: 1 }), e(L, null, { default: a(() => i[2] || (i[2] = [b("span", { class: "title" }, "领用明细", -1)])), _: 1, __: [2] }), N((u(), p($, { data: k.value, "data-format": U.value, "max-height": (t(D) - 100) / 2, "highlight-current-row": "", "show-summary": "", "summary-method": M, "expand-row-keys": A.value, "row-key": "id" }, { default: a(() => [e(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: a(({ row: { sourceRow: l }, $index: W }) => [l.volume ? (u(), p(X, { key: 0, show: !!l.volume, name: "办理" }, null, 8, ["show"])) : _("", true), b("span", null, d(W + 1), 1)]), _: 1 }), e(s, { key: "pickingType", align: "left", label: "领料类型", prop: "pickingType", "show-overflow-tooltip": "", "min-width": "100" }), t(T).basicClass === t(O).SECTION_STEEL.V ? (u(), p(s, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" })) : _("", true), t(T).basicClass === t(O).STEEL_PLATE.V ? (u(), p(s, { key: "thick", label: "厚度(mm)", align: "center", prop: "thick", "show-overflow-tooltip": "", "min-width": "120px" })) : _("", true), e(s, { key: "material", align: "left", label: "材质", prop: "material", "show-overflow-tooltip": "", "min-width": "100" }), e(s, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), e(s, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "", "min-width": "80px" }), e(s, { key: "unit", prop: "unit", label: "核算单位", align: "center", "min-width": "80px" }), e(s, { key: "pickingAmount", prop: "pickingAmount", label: "领料量", align: "center", "show-overflow-tooltip": "", width: "80px" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[Q, H.value]]), e(L, null, { default: a(() => i[3] || (i[3] = [b("span", { class: "title" }, "办理明细", -1)])), _: 1, __: [3] }), e(_e, { list: v.value, dataShowType: "detail", maxHeight: (t(D) - 100) / 2, style: { "margin-top": "10px" } }, null, 8, ["list", "maxHeight"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, De = ce(ye, [["__scopeId", "data-v-3b2ebe33"]]);
export {
  De as default
};
