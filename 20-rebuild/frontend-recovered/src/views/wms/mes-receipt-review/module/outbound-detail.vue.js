import { ref as w } from "vue";
import { inject as U } from "vue";
import { computed as v } from "vue";
import { watch as W } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createVNode as i } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as R } from "vue";
import { isRef as q } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElPopconfirm as K } from "element-plus";
import { f as $ } from "../../../../modules/mes-receipt-review-377f871a.js";
import { _ as X, jX as Y, o as G, u as J, i as T, cO as Z, jl as ee, xY as k, pA as te, Bj as oe, ba as ae } from "../../../../shared/runtime.js";
const ne = { __name: "outbound-detail", props: { modelValue: { type: Boolean, default: false }, showType: { type: String, default: "detail" }, outboundListCurrentRow: { type: Object, default: () => ({}) }, outboundHandledType: { type: String, default: "handled" } }, emits: ["refresh", "update:modelValue", "deleteRow"], setup(d, { emit: H }) {
  const _ = H, r = d, L = w(), y = w(false), N = w([]), B = U("mainCurrentRow"), f = w([]), S = w([...Y, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), V = v(() => "出库明细表"), { maxHeight: A } = G({ mainBox: ".raw-mat-application-review-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300 }, () => v(() => !y.value)), { visible: b, handleClose: j } = J({ emit: _, props: r, closeHook: E });
  W(b, async (t) => {
    var o;
    t && (r.outboundHandledType === "handled" ? await D() : f.value = ((o = r.outboundListCurrentRow) == null ? void 0 : o.currentOutBoundOptions) || []);
  }, { immediate: true });
  async function I(t, o) {
    try {
      t.uid = r.outboundListCurrentRow.uid, f.value.splice(o, 1), Q.success("已删除"), _("deleteRow", t);
    } catch (u) {
      console.log("删除", u);
    }
  }
  async function D() {
    var t;
    if (f.value = [], !!T(r.outboundListCurrentRow)) try {
      y.value = true;
      const o = await $({ pickingIds: (t = r.outboundListCurrentRow) == null ? void 0 : t.pickingList.map((u) => u.pickingId), material: r.outboundListCurrentRow.material, thickness: r.outboundListCurrentRow.thick, specification: r.outboundListCurrentRow.specification });
      if (T(o)) {
        const u = ["brand", "color", "boolPartyA", "heatNoAndBatchNo", "length", "materialSn", "specification", "standardId", "theoryThickness", "thickness", "width", "mete", "quantity"], e = ["outBrand", "outColor", "outBoolPartyA", "outHeatNoAndBatchNo", "outLength", "outMaterialSn", "outSpecification", "outStandardId", "outTheoryThickness", "outThickness", "outWidth", "pickingOutSumMete", "pickingOutSumQuantity"];
        o == null || o.forEach((h) => {
          for (let m = 0; m < u.length; m++) h[u[m]] = h[e[m]];
        }), f.value = await O(o);
      }
    } catch (o) {
      console.log("加载失败", o);
    } finally {
      y.value = false;
    }
  }
  async function O(t) {
    return await Z(t), t = await ee(t, { toSmallest: false, toNum: false }), t;
  }
  function E() {
  }
  function M(t) {
    return ae(t, { props: ["quantity", "mete"] });
  }
  return (t, o) => {
    const u = g("table-cell-tag"), e = z, h = g("common-button"), m = K, P = g("common-table"), F = g("common-drawer");
    return n(), l(F, { ref_key: "drawerRef", ref: L, modelValue: s(b), "onUpdate:modelValue": o[0] || (o[0] = (a) => q(b) ? b.value = a : null), "content-loading": y.value, "close-on-click-modal": false, "before-close": s(j), title: V.value, "show-close": true, size: "80%", "custom-class": "raw-mat-application-review-form" }, { content: p(() => [i(P, { data: f.value, "data-format": S.value, "max-height": s(A), "show-summary": "", "summary-method": M, "expand-row-keys": N.value, "row-key": "id" }, { default: p(() => [i(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: p(({ row: { sourceRow: a }, $index: x }) => [a.boolPartyA ? (n(), l(u, { key: 0, show: !!a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : c("", true), !a.boolPartyA && a.materialIsWhole === s(k).ODDMENT.V ? (n(), l(u, { key: 1, color: s(k).V[a.materialIsWhole].COLOR, name: s(k).VL[a.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : c("", true), C("span", null, R(x + 1), 1)]), _: 1 }), d.outboundHandledType === "handled" ? (n(), l(e, { key: "picking.serialNumber", prop: "picking.serialNumber", "show-overflow-tooltip": "", label: "领料单号", align: "left", "min-width": "120px" })) : c("", true), i(e, { key: "project", align: "left", label: "项目", prop: "project", "show-overflow-tooltip": "", "min-width": "100" }), i(e, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", "min-width": "100" }), i(e, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), i(e, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" }, { default: p(({ row: { sourceRow: a } }) => [C("span", null, R(s(te)(a)), 1)]), _: 1 }), i(e, { key: "brand", align: "left", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "100" }), i(e, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), d.outboundHandledType === "handled" ? (n(), l(e, { key: "quantity", prop: "quantity", label: "数量", "show-overflow-tooltip": "", align: "center", width: "80px" })) : c("", true), d.outboundHandledType === "current" ? (n(), l(e, { key: "outboundQuantity", prop: "outboundQuantity", "show-overflow-tooltip": "", label: "出库数量", align: "center", "min-width": "80px" })) : c("", true), i(e, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), d.outboundHandledType === "handled" ? (n(), l(e, { key: "mete", prop: "mete", label: "核算", "show-overflow-tooltip": "", align: "center", "min-width": "80px" })) : c("", true), d.outboundHandledType === "current" ? (n(), l(e, { key: "outboundMete", prop: "outboundMete", label: "核算", "show-overflow-tooltip": "", align: "center", "min-width": "80px" })) : c("", true), s(B).transactStatus !== s(oe).HANDLED.V && d.outboundHandledType === "current" ? (n(), l(e, { key: 5, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: p((a) => [d.outboundHandledType === "current" ? (n(), l(m, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (x) => I(a.row, a.$index) }, { reference: p(() => [i(h, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : c("", true)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "content-loading", "before-close", "title"]);
  };
} }, ue = X(ne, [["__scopeId", "data-v-0b6193b4"]]);
export {
  ue as default
};
