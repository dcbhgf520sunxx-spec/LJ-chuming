import { ref as S } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as l } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createVNode as f } from "vue";
import { unref as t } from "vue";
import { createTextVNode as p } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as I } from "vue";
import { createElementBlock as m } from "vue";
import { Fragment as j } from "vue";
import { renderList as H } from "vue";
import { normalizeStyle as U } from "vue";
import { isRef as X } from "vue";
import { ElNotification as Z } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElCol as te } from "element-plus";
import { ElRow as ne } from "element-plus";
import { ElTag as ae } from "element-plus";
import { ElForm as le } from "element-plus";
import { l as k, _ as oe, u as ie, o as de, c3 as G, aU as E, es as N, f6 as ue, f7 as se, f8 as w, f5 as P } from "../../../../../shared/runtime.js";
import { _ as T } from "../../../../../modules/index-61ce89a1.js";
function fe(e) {
  return k({ module: "contract", url: "system/structure-classification", method: "get", params: e });
}
function re(e) {
  return k({ module: "contract", url: "system/structure-classification", method: "post", data: e });
}
function ce(e) {
  return k({ module: "contract", url: "system/structure-classification", method: "put", data: e });
}
function me(e) {
  return k({ module: "contract", url: "system/structure-classification", method: "delete", data: e });
}
function ye(e) {
  return k({ module: "contract", url: "system/structure-classification/auditUpdate", method: "put", data: e });
}
const Se = { get: fe, add: re, edit: ce, del: me };
const pe = { key: 1 }, Ie = { key: 1 }, we = { key: 1 }, Te = { key: 1 }, ge = { key: 1 }, be = { key: 0 }, Ee = { key: 0 }, ke = { __name: "audit-form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: "detail" }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: Y }) {
  const V = e, q = S(), v = S(), L = S(false), A = Y, { visible: x, handleClose: R } = ie({ emit: A, props: V }), { maxHeight: J } = de({ extraBox: [".el-drawer__header", ".detail-header"], wrapperBox: [".el-drawer__body"], navbar: false, extraHeight: 120 }, () => v.value.loaded);
  async function O(D) {
    L.value = true;
    try {
      console.log("props.detailInfo:", V.detailInfo), await ye({ id: V.detailInfo.lastChangeId, auditType: D, mesProductEnum: V.detailInfo.mesProductEnum }), Z({ title: "审核成功", type: "success" }), A("success"), R();
    } catch (i) {
      console.log("提交失败", i);
    } finally {
      L.value = false;
    }
  }
  return (D, i) => {
    const B = $("common-button"), y = ee, g = te, C = ne, F = ae, K = le, Q = $("common-drawer");
    return l(), r(Q, { ref_key: "drawerRef", ref: v, "append-to-body": "", modelValue: t(x), "onUpdate:modelValue": i[2] || (i[2] = (b) => X(x) ? x.value = b : null), "before-close": t(R), title: "构件特征定义审核", center: false, "close-on-click-modal": false, size: "800px" }, { titleRight: o(() => [f(B, { loading: L.value, type: "primary", size: "default", onClick: i[0] || (i[0] = (b) => O(t(G).PASS.V)) }, { default: o(() => i[3] || (i[3] = [p("通过")])), _: 1, __: [3] }, 8, ["loading"]), f(B, { loading: L.value, type: "warning", size: "default", onClick: i[1] || (i[1] = (b) => O(t(G).REJECT.V)) }, { default: o(() => i[4] || (i[4] = [p("驳回")])), _: 1, __: [4] }, 8, ["loading"])]), content: o(() => [f(K, { ref_key: "formRef", ref: q, size: "default", "label-width": "140px", "max-height": t(J) }, { default: o(() => {
      var b, z, _, M, W;
      return [f(y, { label: "生产线", prop: "productionLineTypeEnum" }, { default: o(() => {
        var a;
        return [h("div", null, c(t(E).VL[(a = e.detailInfo) == null ? void 0 : a.productionLineTypeEnum]), 1)];
      }), _: 1 }), ((b = e.detailInfo) == null ? void 0 : b.productionLineTypeEnum) === t(E).TRADITION.V ? (l(), r(y, { key: 0, label: "构件类型", prop: "artifactType" }, { default: o(() => {
        var a;
        return [h("span", null, c(t(N).VL[(a = e.detailInfo) == null ? void 0 : a.artifactType]), 1)];
      }), _: 1 })) : I("", true), e.detailInfo.artifactType === t(N).SMALL.V ? (l(), r(y, { key: 1, label: "次构件类型", prop: "newSmallArtifactClassEnum" }, { default: o(() => {
        var a, n, s, d, u;
        return [((a = e.detailInfo) == null ? void 0 : a.smallArtifactClassEnum) !== ((n = e.detailInfo) == null ? void 0 : n.newSmallArtifactClassEnum) ? (l(), r(t(T), { key: 0, old: (s = e.detailInfo) == null ? void 0 : s.smallArtifactClassEnum, new: (d = e.detailInfo) == null ? void 0 : d.newSmallArtifactClassEnum }, null, 8, ["old", "new"])) : (l(), m("span", pe, c(t(ue).VL[(u = e.detailInfo) == null ? void 0 : u.smallArtifactClassEnum]), 1))];
      }), _: 1 })) : I("", true), ((z = e.detailInfo) == null ? void 0 : z.productionLineTypeEnum) === t(E).INTELLECT.V ? (l(), r(y, { key: 2, label: "类型", prop: "newParentType" }, { default: o(() => {
        var a, n, s, d, u;
        return [((a = e.detailInfo) == null ? void 0 : a.parentType) !== ((n = e.detailInfo) == null ? void 0 : n.newParentType) ? (l(), r(t(T), { key: 0, old: (s = e.detailInfo) == null ? void 0 : s.parentType, new: (d = e.detailInfo) == null ? void 0 : d.newParentType }, null, 8, ["old", "new"])) : (l(), m("span", Ie, c(t(se).VL[(u = e.detailInfo) == null ? void 0 : u.parentType]), 1))];
      }), _: 1 })) : I("", true), (_ = e.detailInfo) != null && _.productionLineTypeEnum ? (l(), r(y, { key: 3, label: "类型命名", prop: "newClassificationName" }, { default: o(() => {
        var a, n, s, d, u;
        return [((a = e.detailInfo) == null ? void 0 : a.classificationName) !== ((n = e.detailInfo) == null ? void 0 : n.newClassificationName) ? (l(), r(t(T), { key: 0, old: (s = e.detailInfo) == null ? void 0 : s.classificationName, new: (d = e.detailInfo) == null ? void 0 : d.newClassificationName }, null, 8, ["old", "new"])) : (l(), m("span", we, c((u = e.detailInfo) == null ? void 0 : u.classificationName), 1))];
      }), _: 1 })) : I("", true), ((M = e.detailInfo) == null ? void 0 : M.productionLineTypeEnum) === t(E).INTELLECT.V ? (l(), r(y, { key: 4, label: "定义代码", prop: "newDefinitionWord" }, { default: o(() => {
        var a, n, s, d, u;
        return [((a = e.detailInfo) == null ? void 0 : a.definitionWord) !== ((n = e.detailInfo) == null ? void 0 : n.newDefinitionWord) ? (l(), r(t(T), { key: 0, old: (s = e.detailInfo) == null ? void 0 : s.definitionWord, new: (d = e.detailInfo) == null ? void 0 : d.newDefinitionWord }, null, 8, ["old", "new"])) : (l(), m("span", Te, c((u = e.detailInfo) == null ? void 0 : u.definitionWord), 1))];
      }), _: 1 })) : I("", true), f(y, { label: "排序", prop: "sort" }, { default: o(() => {
        var a, n, s, d, u;
        return [((a = e.detailInfo) == null ? void 0 : a.sort) !== ((n = e.detailInfo) == null ? void 0 : n.newSort) ? (l(), r(t(T), { key: 0, old: (s = e.detailInfo) == null ? void 0 : s.sort, new: (d = e.detailInfo) == null ? void 0 : d.newSort }, null, 8, ["old", "new"])) : (l(), m("span", ge, c((u = e.detailInfo) == null ? void 0 : u.sort), 1))];
      }), _: 1 }), f(y, { label: "构件规格前缀", prop: "specPrefixList" }, { default: o(() => {
        var a;
        return [f(C, null, { default: o(() => [f(g, { span: 6 }, { default: o(() => i[5] || (i[5] = [p("更改类型")])), _: 1, __: [5] }), f(g, { span: 18 }, { default: o(() => i[6] || (i[6] = [p("内容")])), _: 1, __: [6] })]), _: 1 }), (l(true), m(j, null, H((a = e.detailInfo) == null ? void 0 : a.newSpecPrefixList, (n, s) => (l(), r(C, { key: s }, { default: o(() => {
          var d;
          return [f(g, { span: 6 }, { default: o(() => {
            var u;
            return [f(F, { type: (u = t(w).V[n.changeType]) == null ? void 0 : u.TAG }, { default: o(() => [p(c(t(w).VL[n.changeType]), 1)]), _: 2 }, 1032, ["type"])];
          }), _: 2 }, 1024), n.changeType === t(w).MODIFY.V ? (l(), m("span", be, [f(t(T), { old: n.specPrefix, new: n.newSpecPrefix }, null, 8, ["old", "new"])])) : (l(), m("span", { key: 1, style: U(`color:${(d = t(w).V[n.changeType]) == null ? void 0 : d.COLOR}`) }, c(n.newSpecPrefix), 5))];
        }), _: 2 }, 1024))), 128))];
      }), _: 1 }), e.detailInfo.artifactType === t(N).SMALL.V ? (l(), r(y, { key: 5, label: "编号类型索引", prop: "serialNumberPrefixList" }, { default: o(() => {
        var a;
        return [f(C, null, { default: o(() => [f(g, { span: 6 }, { default: o(() => i[7] || (i[7] = [p("更改类型")])), _: 1, __: [7] }), f(g, { span: 18 }, { default: o(() => i[8] || (i[8] = [p("内容")])), _: 1, __: [8] })]), _: 1 }), (l(true), m(j, null, H((a = e.detailInfo) == null ? void 0 : a.newSerialNumberPrefixList, (n, s) => (l(), r(C, { key: s }, { default: o(() => {
          var d;
          return [f(g, { span: 6 }, { default: o(() => {
            var u;
            return [f(F, { type: (u = t(w).V[n.changeType]) == null ? void 0 : u.TAG }, { default: o(() => [p(c(t(w).VL[n.changeType]), 1)]), _: 2 }, 1032, ["type"])];
          }), _: 2 }, 1024), n.changeType === t(w).MODIFY.V ? (l(), m("span", Ee, [f(t(T), { old: n.serialNumberPrefix, new: n.newSerialNumberPrefix }, null, 8, ["old", "new"])])) : (l(), m("span", { key: 1, style: U(`color:${(d = t(w).V[n.changeType]) == null ? void 0 : d.COLOR}`) }, c(n.newSerialNumberPrefix), 5))];
        }), _: 2 }, 1024))), 128))];
      }), _: 1 })) : I("", true), ((W = e.detailInfo) == null ? void 0 : W.productionLineTypeEnum) === t(E).TRADITION.V ? (l(), r(y, { key: 6, label: "打码方式", prop: "codingType" }, { default: o(() => {
        var a, n;
        return [((a = e.detailInfo) == null ? void 0 : a.codingType) !== ((n = e.detailInfo) == null ? void 0 : n.newCodingType) ? (l(), r(t(T), { key: 0, old: t(P).VL[e.detailInfo.codingType], new: t(P).VL[e.detailInfo.newCodingType] }, null, 8, ["old", "new"])) : I("", true), h("span", null, c(t(P).VL[e.detailInfo.newCodingType]), 1)];
      }), _: 1 })) : I("", true)];
    }), _: 1 }, 8, ["max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ve = oe(ke, [["__scopeId", "data-v-26f7f387"]]), he = Object.freeze(Object.defineProperty({ __proto__: null, default: Ve }, Symbol.toStringTag, { value: "Module" }));
export {
  Ve as a,
  he as b,
  Se as c
};
