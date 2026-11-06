import { ref as W } from "vue";
import { computed as F } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as p } from "vue";
import { unref as a } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as o } from "vue";
import { withModifiers as U } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as h } from "vue";
import { withDirectives as B } from "vue";
import { createElementVNode as G } from "vue";
import { toDisplayString as Y } from "vue";
import { ElTableColumn as z } from "element-plus";
import { i as X } from "../../../../../../modules/common-913d415d.js";
import { t as $, o as j, bT as R, kA as _, ky as Q, gt as q, kz as i, iB as K, c as J, D as Z, G as ee, kD as w } from "../../../../../../shared/runtime.js";
import { _ as V } from "../../../../../../modules/index-61ce89a1.js";
const te = { key: 0 }, ae = { style: { color: "red" } }, oe = { key: 0 }, ce = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} } }, emits: ["success"], setup(A, { emit: C }) {
  const { decimalPrecision: d } = $(), D = C, l = A, { maxHeight: L } = j({ extraBox: ".el-drawer__header", wrapperBox: "", extraHeight: 4 }), u = W([]), N = F(() => [["oldUnitPrice", ["to-thousand", d.value.contract === 2 ? 3 : d.value.contract]], ["newUnitPrice", ["to-thousand", d.value.contract === 2 ? 3 : d.value.contract]], ["newPricingManner", ["parse-enum", R]], ["category", ["parse-enum", _]], ["useProperty", ["parse-enum", Q]]]), { crud: m, detail: S, CRUD: b } = q();
  b.HOOK.beforeDetailLoaded = async (g) => {
    u.value = [];
    try {
      u.value = S.content.map((e) => {
        switch (l.detailInfo.type) {
          case i.MACHINE_PART.V:
          case i.STRUCTURE.V:
            e.totalWeight = J(e.totalWeight, "kg", "t", Z.COM_WT__T), e.totalPrice = (e.newPricingManner === R.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.newUnitPrice || 0);
            break;
          case i.ENCLOSURE.V:
            e.totalPrice = (e.newPricingManner === K.LENGTH.V ? e.totalLength : e.totalArea) * (e.newUnitPrice || 0);
            break;
          default:
            e.totalPrice = e.mete * (e.newUnitPrice || 0);
        }
        return e;
      }) || [];
    } catch {
      g.notify("获取构件详情", b.NOTIFICATION_TYPE.ERROR);
    }
  };
  async function E(g) {
    try {
      await X({ id: l.detailInfo.id, status: g }), m.notify("审核成功", b.NOTIFICATION_TYPE.SUCCESS), m.cancelDetail();
    } catch (e) {
      console.log("商务审核失败", e);
    } finally {
      D("success");
    }
  }
  return (g, e) => {
    const P = k("common-button"), t = z, M = k("common-table"), x = k("common-dialog"), O = H("thousand");
    return n(), s(x, { title: "变更详情", "append-to-body": "", visible: a(m).detailVisible, width: "1200px", "before-close": a(m).cancelDetail, "show-close": "", top: "8vh" }, { titleRight: p(() => [a(ee)(a(m).permission.audit) && l.detailInfo.status === a(w).UNREVIEWED.V ? (n(), y("span", te, [o(P, { size: "default", type: "success", onClick: e[0] || (e[0] = U((f) => E(a(w).PASS.V), ["stop"])) }, { default: p(() => e[2] || (e[2] = [T("同 意")])), _: 1, __: [2] }), o(P, { size: "default", type: "danger", onClick: e[1] || (e[1] = U((f) => E(a(w).REFUSE.V), ["stop"])) }, { default: p(() => e[3] || (e[3] = [T("拒 绝")])), _: 1, __: [3] })])) : c("", true)]), default: p(() => [o(M, { data: u.value, "data-format": N.value, "max-height": a(L) - 180 }, { default: p(() => {
      var f, I, v;
      return [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { "show-overflow-tooltip": true, prop: "name", key: "name", label: "名称", align: "center" }), l.detailInfo.type === a(i).STRUCTURE.V || l.detailInfo.type === a(i).MACHINE_PART.V ? (n(), y(h, { key: 0 }, [o(t, { prop: "material", key: "material", label: "材质", align: "center" }), o(t, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }), o(t, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "总量（t）", align: "center" })], 64)) : c("", true), l.detailInfo.type === a(i).ENCLOSURE.V ? (n(), y(h, { key: 1 }, [((f = u.value[0]) == null ? void 0 : f.category) !== a(_).FOLDING_PIECE.V ? (n(), s(t, { key: 0, prop: "plate", label: "板型", align: "center" })) : c("", true), ((I = u.value[0]) == null ? void 0 : I.category) === a(_).FOLDING_PIECE.V ? (n(), s(t, { prop: "unfoldedWidth", key: "unfoldedWidth", label: "展开厚度（mm）", align: "center", width: "120" })) : c("", true), ((v = u.value[0]) == null ? void 0 : v.category) === a(_).FOLDING_PIECE.V ? (n(), s(t, { prop: "bendTimes", key: "bendTimes", label: "折弯次数", align: "center" })) : c("", true), o(t, { prop: "thickness", key: "thickness", label: "厚度（mm）", align: "center", width: "100" }), o(t, { key: "brand", prop: "brand", label: "品牌", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "color", prop: "color", label: "颜色", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "totalArea", prop: "totalArea", label: "总面积", align: "center", "show-overflow-tooltip": "" }), o(t, { key: "category", prop: "category", label: "类别", align: "center", "show-overflow-tooltip": "" })], 64)) : c("", true), l.detailInfo.type === a(i).AUXILIARY_MATERIAL.V ? (n(), y(h, { key: 2 }, [o(t, { prop: "useProperty", key: "useProperty", label: "使用类别", align: "center" }), o(t, { prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }), o(t, { prop: "mete", key: "mete", label: "核算量", align: "center" }), o(t, { prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" }), o(t, { prop: "specification", key: "specification", label: "规格" })], 64)) : c("", true), l.detailInfo.type !== a(i).AUXILIARY_MATERIAL.V ? (n(), s(t, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": "", label: "总长度（m）", align: "center", "min-width": "120" })) : c("", true), l.detailInfo.type !== a(i).AUXILIARY_MATERIAL.V ? (n(), s(t, { align: "center", prop: "newPricingManner", key: "newPricingManner", label: "计价方式" })) : c("", true), o(t, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "show-overflow-tooltip": "", width: "60" }), o(t, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: p(({ row: r }) => [B(G("span", ae, null, 512), [[O, { val: r.totalPrice || 0, dp: a(d).contract === 2 ? 3 : a(d).contract }]])]), _: 1 }), o(t, { align: "center", prop: "price", label: "综合单价" }, { default: p(({ row: r }) => [l.detailInfo.type === a(i).STRUCTURE.V ? (n(), y(h, { key: 0 }, [r.oldUnitPrice === r.newUnitPrice ? (n(), y("span", oe, Y(r.oldUnitPrice), 1)) : (n(), s(a(V), { key: 1, old: r.oldUnitPrice, new: r.newUnitPrice }, null, 8, ["old", "new"]))], 64)) : (n(), s(a(V), { key: 1, old: r.oldUnitPrice, new: r.newUnitPrice }, null, 8, ["old", "new"]))]), _: 1 })];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  ce as default
};
