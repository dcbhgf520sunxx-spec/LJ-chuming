import { ref as L } from "vue";
import { computed as V } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as m } from "vue";
import { createBlock as d } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as v } from "vue";
import { createElementVNode as H } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as U } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { D as g, gt as F, o as I, kA as P, ba as Q } from "../../../../../../shared/runtime.js";
const J = { __name: "detail", props: { project: { type: Object, default: () => {
} } }, setup(D) {
  const E = D, N = L(), x = L([["totalLength", ["to-fixed", g.MES_ENCLOSURE_L__M]], ["completeLength", ["to-fixed", g.MES_ENCLOSURE_L__M]]]), { CRUD: C, crud: c, detail: n } = F(), { maxHeight: S } = I({ mainBox: ".enclosure-task-tracking-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, () => V(() => !c.detailLoading));
  function M(f) {
    return Q(f, { props: [["totalLength", g.MES_ENCLOSURE_L__M], ["completeLength", g.MES_ENCLOSURE_L__M]] });
  }
  return C.HOOK.beforeDetailLoaded = async (f) => {
    (n.content || []).forEach((i) => {
      i.totalLength = (i.totalLength || 0) / 1e3, i.completeLength = (i.completeLength || 0) / 1e3;
    });
  }, (f, i) => {
    var h, y;
    const s = q, R = u("print-table"), a = A, z = u("common-table"), O = u("common-drawer"), j = w("empty-text"), B = w("parse-project"), T = w("permission");
    return m(), d(O, { ref_key: "drawerRef", ref: N, "before-close": o(c).cancelDetail, "content-loading": o(c).detailLoading, "show-close": true, title: (y = (h = o(n)) == null ? void 0 : h.rowDetail) == null ? void 0 : y.orderNumber, visible: o(c).detailVisible, "custom-class": "enclosure-task-tracking-detail", size: "100%" }, { titleAfter: r(() => [e(s, { effect: "plain", size: "large" }, { default: r(() => [v(H("span", null, null, 512), [[j], [B, { project: E.project }]])]), _: 1 }), e(s, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var t, l;
      return [p(_((l = (t = o(n)) == null ? void 0 : t.rowDetail) == null ? void 0 : l.factoryName), 1)];
    }), _: 1 }), e(s, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var t, l;
      return [p(_((l = (t = o(n)) == null ? void 0 : t.rowDetail) == null ? void 0 : l.workshopName), 1)];
    }), _: 1 }), e(s, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var t, l, b, k;
      return [p(_((l = (t = o(n)) == null ? void 0 : t.rowDetail) == null ? void 0 : l.productionLineName) + " / " + _((k = (b = o(n)) == null ? void 0 : b.rowDetail) == null ? void 0 : k.leaderName), 1)];
    }), _: 1 })]), titleRight: r(() => {
      var t, l;
      return [v(e(R, { params: { id: (l = (t = o(n)) == null ? void 0 : t.rowDetail) == null ? void 0 : l.id }, "api-key": "enclosureTaskTrackingDetail", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[T, o(c).permission.print]])];
    }), content: r(() => [e(z, { data: o(n).content, "data-format": x.value, "max-height": o(S), "summary-method": M, "show-summary": "" }, { default: r(() => {
      var t;
      return [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { key: "areaName", align: "center", label: "区域", prop: "areaName", "show-overflow-tooltip": "" }), e(a, { key: "name", align: "center", label: "名称", prop: "name", "show-overflow-tooltip": "" }), e(a, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), ((t = o(n).rowDetail) == null ? void 0 : t.category) !== o(P).FOLDING_PIECE.V ? (m(), d(a, { key: "plate", align: "center", label: "板型", prop: "plate", "show-overflow-tooltip": "" })) : U("", true), e(a, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(a, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(a, { key: "length", align: "center", label: "单长(mm)", prop: "length", "show-overflow-tooltip": "" }), e(a, { key: "quantity", align: "center", label: "数量(件)", prop: "quantity", "show-overflow-tooltip": "" }), e(a, { key: "totalLength", align: "center", label: "总长度(m)", prop: "totalLength", "show-overflow-tooltip": "" }), e(a, { key: "completeQuantity", align: "center", label: "完成数(件)", prop: "completeQuantity", "show-overflow-tooltip": "" }), e(a, { key: "completeLength", align: "center", label: "完成量(m)", prop: "completeLength", "show-overflow-tooltip": "" }), e(a, { key: "booleanlag", align: "center", label: "状态", prop: "booleanlag", "show-overflow-tooltip": "" }, { default: r(({ row: l }) => [l.booleanlag ? (m(), d(s, { key: 0, effect: "plain", size: "large", type: "success" }, { default: r(() => i[0] || (i[0] = [p("正常")])), _: 1, __: [0] })) : (m(), d(s, { key: 1, effect: "plain", size: "large", type: "danger" }, { default: r(() => i[1] || (i[1] = [p("滞后")])), _: 1, __: [1] }))]), _: 1 })];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} };
export {
  J as default
};
