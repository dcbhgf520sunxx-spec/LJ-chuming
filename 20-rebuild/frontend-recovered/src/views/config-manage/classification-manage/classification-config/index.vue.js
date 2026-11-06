import { ref as o } from "vue";
import { reactive as p } from "vue";
import { provide as m } from "vue";
import { resolveComponent as H } from "vue";
import { withDirectives as T } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as l } from "vue";
import { withCtx as R } from "vue";
import { unref as q } from "vue";
import { ElMessage as x } from "element-plus";
import { ElMessageBox as F } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as j, o as z, aS as O, cC as J, cD as M, G as K, cE as Q, i as d, cF as W, cG as X } from "../../../../shared/runtime.js";
import { u as E } from "../../../../modules/use-refresh-store-3f8d2c0c.js";
import Y from "./module/root-card.vue.js";
import U from "./module/child-card.vue.js";
import Z from "./module/batch-add.vue.js";
import "../../../../modules/index-fd3331da.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/use-add-form-local-storage-75741656.js";
const aa = { class: "app-container" }, ta = { id: "card-main-content", class: "flex-rsc", style: { "padding-bottom": "20px", "overflow-x": "auto" } }, sa = { __name: "index", setup(ea) {
  const { maxHeight: v } = z({ extraBox: null, wrapperBox: [".app-container", "#card-main-content"] }), N = o(1), h = p({ batchAdd: false }), _ = p({ data: false }), n = p({ LV1: [], LV2: [], LV3: [] }), r = p({ current_LV1: void 0, current_LV2: void 0, current_LV3: void 0, current_list_LV1: void 0, current_list_LV2: void 0, current_list_LV3: void 0 }), b = o([]), P = o([]), B = o(), V = o(O.TRUE.V);
  m("permission", J), m("crudApi", M), m("maxHeight", v), m("selectMap", r), u();
  function L(a) {
    N.value = a, h.batchAdd = true;
  }
  const f = o();
  async function u() {
    const a = JSON.parse(JSON.stringify(r));
    if (K(J.get)) {
      _.data = true;
      try {
        Object.keys(n).forEach((s) => {
          n[s] = [];
        });
        const t = await M.get({ status: V.value });
        C(t), f.value = JSON.parse(JSON.stringify(n)), r.current_LV1 = a == null ? void 0 : a.current_LV1, r.current_LV2 = a == null ? void 0 : a.current_LV2, r.current_LV3 = a == null ? void 0 : a.current_LV3;
      } catch (t) {
        console.log("error", t);
      } finally {
        _.data = false;
      }
    }
  }
  function C(a, t, s = 1) {
    const e = n[`LV${s}`];
    a.forEach((i) => {
      const c = { parent: t, id: i.id, name: i.name, code: i.code, boolStatus: i.boolStatus, boolLastEnum: i.boolLastEnum, boolUsed: i.boolUsed, basicClass: s === 1 ? i.basicClass : t.basicClass, basicClassName: s === 1 ? Q.VL[`${i.basicClass}`] : t.basicClassName, serialNumber: `${d(t) ? t.serialNumber : ""}${i.code}`, fullPath: [], classifyUpdateStatus: i.classifyUpdateStatus };
      d(c.parent) ? c.fullPath = [...c.parent.fullPath, c.id] : c.fullPath = [c.id], e.push(c), d(i.children) && C(i.children, c, s + 1);
    });
  }
  async function w() {
    await u(), E(["classification", "classificationTree"]);
  }
  async function S() {
    await u(), E(["classification", "classificationTree"]);
  }
  function $(a, t, s) {
    if (s === false) {
      if (t > 3) return;
      t + 1 <= 3 && n[`LV${t + 1}`].forEach((e) => {
        e.fullPath.includes(a.id) && (e.boolStatus = s);
      }), t = t + 1, $(a, t, s);
    } else t === 1 && n.LV2.forEach((e) => {
      a.fullPath.includes(e.fullPath[0]) && (e.boolStatus = true);
    }), t === 3 && n.LV2.forEach((e) => {
      a.fullPath.includes(e.fullPath[1]) && (e.boolStatus = true);
    }), (t === 1 || t === 2) && n.LV3.forEach((e) => {
      a.fullPath.includes(e.fullPath[0]) && (e.boolStatus = true);
    }), (t === 2 || t === 3) && n.LV1.forEach((e) => {
      a.fullPath.includes(e.fullPath[0]) && (e.boolStatus = true);
    });
  }
  async function g(a, t, s) {
    b.value = [], b.value.push(a.id), $(a, t, s);
    const e = { ids: b.value, status: s };
    await W(e).then(async (i) => {
      i && (s ? x({ type: "success", message: "启用成功" }) : x({ type: "success", message: "禁用成功" }), await u(), E(["classification", "classificationTree"]));
    });
  }
  async function y(a, t, s) {
    t && F.confirm("是否确认修改科目", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      await X(a).then((e) => {
        e && (P.value = a, B.value = s, A(s, P.value), x({ type: "success", message: "编辑成功" }));
      }).catch(() => {
        n[`LV${s}`] = JSON.parse(JSON.stringify(f.value[`LV${s}`]));
      }), f.value = JSON.parse(JSON.stringify(n));
    }).catch(() => {
      n[`LV${s}`] = JSON.parse(JSON.stringify(f.value[`LV${s}`]));
    });
  }
  function A(a, t) {
    a + 1 <= 3 && (n[`LV${a + 1}`].forEach((s) => {
      t.forEach((e) => {
        d(s.parent) && s.parent.id === e.parentId && (s.serialNumber = e.serialNumber);
      }), s.serialNumber = `${d(s.parent) ? s.parent.serialNumber : ""}${s.code}`;
    }), a++, a > 3 && (a = B.value), A(a, t));
  }
  return (a, t) => {
    const s = H("common-radio-button"), e = G;
    return T((k(), D("div", aa, [I("div", ta, [l(Y, { data: n.LV1, level: 1, class: "box-card lv-one-card", onAdd: L, onDel: S, onChangeBoolStatusSuccess: g, onHandleEdit: y }, { statusSearch: R(() => [l(s, { modelValue: V.value, "onUpdate:modelValue": t[0] || (t[0] = (i) => V.value = i), options: q(O).ENUM, class: "filter-item", style: { "margin-right": "5px" }, "show-option-all": "", size: "mini", type: "enum", onChange: u }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["data"]), l(U, { data: n.LV2, level: 2, class: "box-card lv-two-card", onAdd: L, onDel: S, onChangeBoolStatusSuccess: g, onHandleEdit: y }, null, 8, ["data"]), l(U, { data: n.LV3, level: 3, class: "box-card lv-three-card", onAdd: L, onDel: S, onChangeBoolStatusSuccess: g, onHandleEdit: y }, null, 8, ["data"])]), l(Z, { modelValue: h.batchAdd, "onUpdate:modelValue": t[1] || (t[1] = (i) => h.batchAdd = i), level: N.value, onSuccess: w }, null, 8, ["modelValue", "level"])])), [[e, _.data]]);
  };
} }, pa = j(sa, [["__scopeId", "data-v-4bb59d7d"]]);
export {
  pa as default
};
