import { ref as l } from "vue";
import { watch as q } from "vue";
import { provide as K } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as p } from "vue";
import { createBlock as g } from "vue";
import { withCtx as c } from "vue";
import { createVNode as b } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as k } from "vue";
import { unref as s } from "vue";
import { createElementBlock as W } from "vue";
import { Fragment as G } from "vue";
import { createCommentVNode as S } from "vue";
import { withModifiers as X } from "vue";
import { isRef as Y } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTag as ee } from "element-plus";
import { q as te, r as ae, s as oe } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ie, u as re, o as ne, i as d, es as le, z as ce, m9 as _ } from "../../../../../shared/runtime.js";
import se from "./repeat-detail.vue.js";
import ue from "./type-detail.vue.js";
import fe from "./PL-detail.vue.js";
import "../../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
import "./auto-combination.vue.js";
import "../../../../../modules/assembly-template-config-631cc212.js";
import "./PL-config.vue.js";
const me = { __name: "confirm-detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(L, { emit: I }) {
  const R = I, w = L, n = l(0), v = l(0), E = l(), U = l(), y = l(), { visible: T, handleClose: P } = re({ emit: R, props: w, showHook: J, closeHook: Q }), h = l(), f = l(false), x = l(false), o = l({}), O = l([]), { maxHeight: N } = ne({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, h);
  q(T, (i) => {
    i && (o.value = l({}), C());
  }, { immediate: true, deep: true });
  function z() {
    n.value < 1 && n.value++;
  }
  async function C(i = { boolCombination: false }) {
    if (o.value = {}, v.value = 0, n.value = 0, !!w.currentRow.id) {
      x.value = true;
      try {
        const e = await te({ inventoryId: w.currentRow.id, ...i });
        d(e == null ? void 0 : e.artifactRecordDTOList) && d(e == null ? void 0 : e.artifactSpecUncorrectedDTOS) ? (v.value = 1, n.value = 0) : !d(e == null ? void 0 : e.artifactRecordDTOList) && d(e == null ? void 0 : e.artifactSpecUncorrectedDTOS) && (n.value = 1), d(e == null ? void 0 : e.artifactSpecUncorrectedDTOS) && (e == null || e.artifactSpecUncorrectedDTOS.map((a, t) => {
          a.newStructureClassId = t > 0 ? -1 : void 0, a.newName = t > 0 ? -1 : void 0, a.newSpecPrefix = t > 0 ? -1 : void 0, a.newSpecification = t > 0 ? "同上" : void 0;
        })), d(e == null ? void 0 : e.artifactSpecUncorrectedDTOSPL) && (e == null || e.artifactSpecUncorrectedDTOSPL.map((a, t) => {
        })), o.value = e, F({ mesProductEnum: e.mesProductEnum });
      } catch (e) {
        console.log("获取区域清单待确认详情", e);
      } finally {
        x.value = false;
      }
    }
  }
  function Q() {
    var i;
    (i = U.value) == null || i.reset();
  }
  async function F({ mesProductEnum: i }) {
    y.value = [], O.value = [], f.value = true;
    try {
      const e = [], a = await ae({ mesProductEnum: i });
      for (const t in a) a[t].map((u) => {
        u.artifactTypeEnumVal = Number(t), u.classificationName = u.classificationName + `${u.boolComposeAssemble ? "  (需组立)" : "  (无需组立)"}`;
      }), e.push({ id: "parent_" + t, classificationName: le.VL[t], children: a[t] }), O.value.push(...a[t]);
      y.value = e, console.log(": artifactTypeConfig.value ", y.value), R("success", y.value);
    } catch (e) {
      console.log("获取构件类型配置", e);
    } finally {
      f.value = false;
    }
  }
  async function A(i) {
    var t, u, r, D, H, B;
    const e = d((t = o.value) == null ? void 0 : t.artifactSpecUncorrectedDTOS) && i === _.UNAUDITED.V ? (u = E.value) == null ? void 0 : u.validate() : true, a = d((r = o.value) == null ? void 0 : r.artifactSpecUncorrectedDTOSPL) && i === _.UNAUDITED.V ? (D = U.value) == null ? void 0 : D.validate() : true;
    if (!(!e || !a)) {
      f.value = true;
      try {
        const V = JSON.parse(JSON.stringify((H = o.value) == null ? void 0 : H.artifactSpecUncorrectedDTOS)), M = JSON.parse(JSON.stringify((B = o.value) == null ? void 0 : B.artifactSpecUncorrectedDTOSPL)), $ = { checkStatus: i, id: w.currentRow.id, paramList: [...V, ...M] };
        await oe($), Z({ message: i === _.UNAUDITED.V ? "保存成功" : "撤回成功", type: "success" }), R("success"), P();
      } catch (V) {
        console.log("区域清单审核", V);
      } finally {
        f.value = false;
      }
    }
  }
  K("fetchDetail", C);
  function J() {
  }
  return (i, e) => {
    const a = ee, t = j("common-button"), u = j("common-drawer");
    return p(), g(u, { ref_key: "drawerRef", ref: h, title: "构件类型修正", "close-on-click-modal": false, modelValue: s(T), "onUpdate:modelValue": e[3] || (e[3] = (r) => Y(T) ? T.value = r : null), direction: "rtl", "before-close": s(P), "custom-class": "inbound-record", size: "100%" }, { titleAfter: c(() => [b(a, null, { default: c(() => [m("项目：" + k(s(ce)(L.globalProject)), 1)]), _: 1 }), b(a, { type: "success" }, { default: c(() => {
      var r;
      return [m("单体：" + k((r = o.value) == null ? void 0 : r.monomerName), 1)];
    }), _: 1 }), b(a, { type: "warning" }, { default: c(() => [m(" 区域：" + k(o.value.areaName), 1)]), _: 1 }), b(a, { type: "warning" }, { default: c(() => [m("批次：" + k(o.value.areaBatchName), 1)]), _: 1 })]), titleRight: c(() => [v.value > 0 ? (p(), W(G, { key: 0 }, [n.value != 0 && n.value !== v.value ? (p(), g(t, { key: 0, disabled: f.value, type: "warning", size: "default", onClick: e[0] || (e[0] = (r) => n.value--) }, { default: c(() => e[4] || (e[4] = [m(" 上一步 ")])), _: 1, __: [4] }, 8, ["disabled"])) : S("", true), n.value < 1 ? (p(), g(t, { key: 1, type: "primary", size: "default", disabled: f.value, onClick: X(z, ["stop"]) }, { default: c(() => e[5] || (e[5] = [m("下一步")])), _: 1, __: [5] }, 8, ["disabled"])) : S("", true)], 64)) : S("", true), n.value === 1 && v.value > 0 || v.value === 0 ? (p(), g(t, { key: 1, loading: f.value, type: "primary", size: "default", onClick: e[1] || (e[1] = (r) => A(s(_).UNAUDITED.V)) }, { default: c(() => e[6] || (e[6] = [m("保存")])), _: 1, __: [6] }, 8, ["loading"])) : S("", true), b(t, { loading: f.value, type: "warning", size: "default", onClick: e[2] || (e[2] = (r) => A(s(_).REVOKED.V)) }, { default: c(() => e[7] || (e[7] = [m("撤回")])), _: 1, __: [7] }, 8, ["loading"])]), content: c(() => {
      var r, D;
      return [n.value === 0 ? (p(), g(s(se), { key: 0, data: o.value.artifactRecordDTOList || [], maxHeight: s(N) }, null, 8, ["data", "maxHeight"])) : S("", true), n.value === 1 ? (p(), g(s(ue), { key: 1, ref_key: "typeDetailRef", ref: E, data: o.value.artifactSpecUncorrectedDTOS || [], artifactTypeConfig: y.value, configList: O.value, maxHeight: s(N) }, null, 8, ["data", "artifactTypeConfig", "configList", "maxHeight"])) : S("", true), b(fe, { ref_key: "PLDetailRef", ref: U, data: o.value.artifactSpecUncorrectedDTOSPL || [], artifactTypeConfig: y.value, mesProductEnum: o.value.mesProductEnum, boardAssembledQuantity: (r = o.value) == null ? void 0 : r.boardAssembledQuantity, unBoardAssembledQuantity: (D = o.value) == null ? void 0 : D.unBoardAssembledQuantity, configList: O.value, currentRow: L.currentRow, maxHeight: s(N), tableLoading: x.value, onFetchDetail: C }, null, 8, ["data", "artifactTypeConfig", "mesProductEnum", "boardAssembledQuantity", "unBoardAssembledQuantity", "configList", "currentRow", "maxHeight", "tableLoading"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ve = ie(me, [["__scopeId", "data-v-534371d4"]]);
export {
  Ve as default
};
