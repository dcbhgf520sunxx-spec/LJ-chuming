import { o as E, cO as O, jl as m, cS as p } from "../shared/runtime.js";
import { ref as t } from "vue";
import { computed as R } from "vue";
function T({ CRUD: y, crud: o, defaultBasicClass: b }) {
  const d = t([]), { maxHeight: h } = E({ paginate: true }), a = t({}), i = t(false), c = t(false), l = t(false), f = t(false), r = t(), z = R(() => o.query.basicClass || b);
  y.HOOK.handleRefresh = async (n, { data: u }) => {
    await O(u.content), u.content = await m(u.content, { toSmallest: false, toNum: false }), u.content.forEach(async (e) => {
      e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === p.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete), Array.isArray(e.projectFrozen) && (e.projectFrozenKV = {}, e.projectFrozenForUnitKV = {}, e.projectFrozen = await m(e.projectFrozen, { measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, toSmallest: false, toNum: true }), e.projectFrozen.forEach((s) => {
        e.projectFrozenForUnitKV[s.projectId] = e.outboundUnitType === p.MEASURE.V ? s.quantity : s.mete, e.projectFrozenKV[s.projectId] = s;
      }));
    });
  };
  function F(n) {
    a.value = n, i.value = true;
  }
  function g(n) {
    a.value = n, c.value = true;
  }
  function j(n) {
    a.value = n, l.value = true;
  }
  function H(n) {
    a.value = n, f.value = true;
  }
  function Q() {
    r.value && r.value.updateListNumber(), o.refresh();
  }
  function S() {
    o.refresh();
  }
  function U() {
    o.refresh();
  }
  function V() {
    r.value && r.value.updateListNumber(), o.refresh();
  }
  function M() {
    o.refresh();
  }
  return { headerRef: r, expandRowKeys: d, maxHeight: h, basicClass: z, currentRow: a, outboundHandlingVisible: i, transferHandlingVisible: c, freezeHandlingVisible: f, movingInventoryHandlingVisible: l, toTransfer: g, toOutHandle: F, toFreezeHandle: H, toMovHandle: j, handleOutboundSuccess: Q, handleTransferSuccess: S, handleFreezeSuccess: U, handleMovSuccess: M, handleRefresh: V };
}
export {
  T as u
};
