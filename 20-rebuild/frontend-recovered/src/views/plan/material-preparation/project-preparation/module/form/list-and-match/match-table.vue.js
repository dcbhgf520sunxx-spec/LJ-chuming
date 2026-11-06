import { ref as r } from "vue";
import { watch as y } from "vue";
import { computed as g } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as E } from "vue";
import { withCtx as x } from "vue";
import { unref as $ } from "vue";
import { ElCheckbox as P } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as v, _ as G, sP as H, kc as W, b as L, bl as h, cO as J, jl as X, sK as Y, cS as Z, jG as ee, k5 as te, sO as ae, k6 as oe } from "../../../../../../../shared/runtime.js";
import { _ as le } from "../../../../../../../modules/factory-select-b8d0a4ac.js";
function se(c) {
  return v({ module: "wms", url: "material-preparation/match/steel-plate", method: "get", cancelKey: false, params: c });
}
function ne(c) {
  return v({ module: "wms", url: "material-preparation/match/section-steel", method: "get", cancelKey: false, params: c });
}
function ie(c) {
  return v({ module: "wms", url: "material-preparation/match/auxiliary-material", method: "get", cancelKey: false, params: c });
}
const ce = { class: "match-table" }, re = { class: "filter-container" }, ue = { class: "filter-left-box" }, de = { class: "filter-right-box" }, fe = { key: 0, style: { color: "#1890ff" } }, me = { __name: "match-table", props: { height: { type: Number, default: 250 }, matchInfo: { type: Object, default: () => ({}) } }, emits: ["add"], setup(c, { emit: N }) {
  const k = N, s = c, T = r([...H]), { CRUD: V, crud: f } = W(), p = r(), _ = r(0);
  y(() => f.props.inventoryExitIdMap, (t) => {
    p.value = t;
  }, { immediate: true });
  const u = r(false), d = r([]), l = r({ factoryId: void 0, boolNotMatch: false, boolNotInInventoryList: false });
  V.HOOK.beforeToEdit = (t, e) => {
    l.value = { factoryId: void 0, boolNotInInventoryList: false };
  };
  const S = g(() => d.value.filter((t) => {
    let e = true;
    const a = l.value.factoryId;
    return a && (e = t.factory.id === a), e && l.value.boolNotInInventoryList && (e = !p.value.get(t.id)), e;
  })), w = g(() => l.value.boolNotMatch ? "不进行物料仓匹配" : f.props.boolTechEditMode ? "编辑清单时，不进行物料仓匹配" : L(s.matchInfo) || u.value ? "可选择左侧清单数据，匹配物料系统公共库中对应的的材料" : "未匹配到物料");
  y(() => s.matchInfo, () => {
    f.props.boolTechEditMode || I();
  }, { immediate: true });
  function z() {
    d.value = [], l.value = { factoryId: void 0, boolNotMatch: false, boolNotInInventoryList: false };
  }
  y(() => f.props.boolTechEditMode, (t) => {
    t && (d.value = []);
  });
  function O() {
    d.value = [];
  }
  async function I() {
    if (l.value.boolNotMatch) return;
    const t = ++_.value;
    z();
    const e = s.matchInfo;
    if (!L(e)) try {
      u.value = true;
      let a = [];
      switch (e.basicClass) {
        case h.STEEL_PLATE.V:
          a = await A(e);
          break;
        case h.SECTION_STEEL.V:
          a = await q(e);
          break;
        case h.MATERIAL.V:
          a = await B(e);
          break;
        default:
          throw Error("物料主分类错误");
      }
      if (t !== _.value) throw Error("repeated calls");
      await J(a), await X(a, { toNum: true }), await Y(a), a.forEach((o) => {
        o.operableQuantity = o.quantity - (o.frozenQuantity || 0), o.operableMete = o.mete - (o.frozenMete || 0), o.outboundUnitType === Z.MEASURE.V ? (o.corQuantity = o.quantity, o.corFrozenQuantity = o.frozenQuantity, o.corOperableQuantity = o.operableQuantity) : (o.corQuantity = o.mete, o.corFrozenQuantity = o.frozenMete, o.corOperableQuantity = o.operableMete), o.operableNumber = o.corOperableQuantity;
      }), d.value = a, u.value = false;
    } catch (a) {
      console.error("匹配物料", a), String(a).indexOf("repeated calls") === -1 && (u.value = false);
    }
  }
  function Q(t) {
    k("add", t, s.matchInfo);
  }
  async function A(t) {
    const e = { steelClassifyConfId: t.steelClassifyConfId, material: t.material, specification: t.specification }, { content: a = [] } = await se(e);
    return a;
  }
  async function q(t) {
    const e = { steelClassifyConfId: t.steelClassifyConfId, material: t.material, specification: t.specification }, { content: a = [] } = await ne(e);
    return a;
  }
  async function B(t) {
    const e = { serialNumber: t.serialNumber, classifyId: t.classifyId, color: t.color, brand: t.brand }, { content: a = [] } = await ie(e);
    return a;
  }
  return (t, e) => {
    const a = P, o = M("common-button"), F = j, R = M("common-table"), K = D;
    return m(), C("div", ce, [b("div", re, [b("div", ue, [e[3] || (e[3] = b("span", { class: "table-title" }, "公共库 · 物料匹配列表", -1)), i(a, { class: "filter-item", modelValue: l.value.boolNotMatch, "onUpdate:modelValue": e[0] || (e[0] = (n) => l.value.boolNotMatch = n), label: "不进行匹配", size: "default", border: "", onChange: O }, null, 8, ["modelValue"])]), b("div", de, [i(le, { modelValue: l.value.factoryId, "onUpdate:modelValue": e[1] || (e[1] = (n) => l.value.factoryId = n), placeholder: "工厂", size: "default", class: "filter-item", clearable: "", style: { width: "170px" }, "only-one-default": "" }, null, 8, ["modelValue"]), i(a, { class: "filter-item", modelValue: l.value.boolNotInInventoryList, "onUpdate:modelValue": e[2] || (e[2] = (n) => l.value.boolNotInInventoryList = n), label: "只显示未加入库存利用清单", size: "default", border: "" }, null, 8, ["modelValue"])])]), U((m(), E(R, { ref: "tableRef", data: S.value, "data-format": T.value, "default-expand-all": false, height: s.height, "empty-text": w.value, "highlight-current-row": "", "row-key": "id" }, { default: x(() => [i(ee, { "show-serial-number": false, "show-is-whole": true, "basic-class": s.matchInfo.basicClass, "show-frozen-tip": "", "frozen-viewable": "", "spec-merge": "", onRefresh: I }, null, 8, ["basic-class"]), i(te, { "basic-class": s.matchInfo.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), i(ae, { "show-unit-net": s.matchInfo.basicClass === $(h).MATERIAL.V, "outbound-type-mode": "", "equal-disabled": "" }, null, 8, ["show-unit-net"]), i(oe), i(F, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: x(({ row: { sourceRow: n } }) => [p.value.get(n.id) ? (m(), C("span", fe, "已加入清单")) : (m(), E(o, { key: 1, icon: "el-icon-plus", type: "success", size: "default", class: "icon-button", onClick: (be) => Q(n) }, null, 8, ["onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "height", "empty-text"])), [[K, u.value]])]);
  };
} }, ve = G(me, [["__scopeId", "data-v-c12a692e"]]);
export {
  ve as default
};
